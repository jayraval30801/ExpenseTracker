package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String FirstName = request.getParameter("FirstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBean userbean = new UserBean();
		userbean.setFirstName(FirstName);
		userbean.setEmail(email);
		userbean.setPassword(password);
		
			UserDao userdao = new UserDao();
			
		     userdao.insertUser(userbean);
			
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			rd.forward(request, response);
			
	}

}
