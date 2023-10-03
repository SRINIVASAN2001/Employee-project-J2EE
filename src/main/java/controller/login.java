package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.Employee_DAO;
import employee.Employee_DTO;

@WebServlet("/login")
public class login extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		HttpSession session=req.getSession();
		
		session.setAttribute("email",email);
		session.setAttribute("password",password);
		
		
		Employee_DAO dao=new Employee_DAO();
		
		 try {
			Employee_DTO e=dao.findByEmail(email);
			
			if(e.getPassword().equals(password))
			{
				List<Employee_DTO> employees=dao.getAll();
				req.setAttribute("employees", employees);
				
				String name=e.getName();
				req.setAttribute("name",name);
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.include(req, resp);
			}
			else {
				
				req.setAttribute("message","Your passwrod is wrong!!!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}
	

}
