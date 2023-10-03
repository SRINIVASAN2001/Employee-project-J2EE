package controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.Employee_DAO;
import employee.Employee_DTO;

@WebServlet("/delete")
public class delete extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Employee_DAO dao=new Employee_DAO();
		
		HttpSession session=req.getSession();
		
		try
		{
			if(session.getAttribute("email")!=null && session.getAttribute("password")!=null)
			{
				dao.delete(id);
				List<Employee_DTO> employees=dao.getAll();
				req.setAttribute("employees", employees);
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("message","Please check your Logins!!!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (SQLException | IOException e){
			e.printStackTrace();
		}
		
	}
}
