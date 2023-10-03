package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signout")
public class signout extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		False argument is used to check for their existing session, if no it will not creating the new session if the session doesn't exist
		HttpSession session =req.getSession(false);
		session.invalidate();
		
		req.setAttribute("message","Logged out successfully");
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}

}
