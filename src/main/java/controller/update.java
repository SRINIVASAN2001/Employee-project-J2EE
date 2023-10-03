package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee_DAO;
import employee.Employee_DTO;

@WebServlet("/update")
public class update extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		
		Employee_DTO e=new Employee_DTO();
		
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setContact(contact);
		e.setPassword(password);
		
		
		Employee_DAO dao=new Employee_DAO();
		try {
			dao.update(e);
			req.setAttribute("employees",dao.getAll());
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.include(req, resp);
			
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
