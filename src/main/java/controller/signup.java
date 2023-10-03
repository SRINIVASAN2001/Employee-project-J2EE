package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee_DAO;
import employee.Employee_DTO;

@WebServlet("/signup")
public class signup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		
		
//implementing the employee so that we can set the data to the employee object		
		Employee_DTO e = new Employee_DTO();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setContact(contact);
		e.setPassword(password);
		
//		create an employee dao object to store the datas into the database using save emplopyee method which we already created
		Employee_DAO dao=new Employee_DAO();
		try
		{
			int res=dao.saveEmployee(e);
			
			if(res>0)
			{
				RequestDispatcher dispacther=req.getRequestDispatcher("index.jsp");
				dispacther.forward(req, resp);
			}
		}
		catch (SQLException | IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
