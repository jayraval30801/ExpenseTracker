package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String FirstName = request.getParameter("FirstName");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	
	UserDao userdao = new UserDao();
	int i = userdao.insertUser(FirstName,email,password);
	
	RequestDispatcher rd = null;
	if(i == 1) {
		rd = request.getRequestDispatcher("Dashboard.jsp");
		
	}else {
		rd = request.getRequestDispatcher("Error.jsp");
	}
	
	rd.forward(request, response);
	
	
	
	}
}
