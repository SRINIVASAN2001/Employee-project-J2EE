package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.Employee_DAO;
import employee.Employee_DTO;

@WebServlet("/edit")
public class edit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		HttpSession session=req.getSession();
//		It is used to make the database secure from other users insted giving direct permissions
		Employee_DAO dao=new Employee_DAO();
		
		
		try
		{
			if(session.getAttribute("email")!=null && session.getAttribute("password")!=null)
			{
				Employee_DTO e=dao.findById(id);
				
				req.setAttribute("emp",e);
			
				RequestDispatcher dispatch=req.getRequestDispatcher("edit.jsp");
				dispatch.include(req, resp);
			}
			else
			{
				req.setAttribute("message","Please check your Logins!!!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
