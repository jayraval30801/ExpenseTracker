package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class SearchUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String FirstName = request.getParameter("FirstName");
		UserDao userDao = new UserDao();

		ResultSet rs = userDao.getUserByName(FirstName);
		request.setAttribute("rs", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListAllUser.jsp"); 
		
		rd.forward(request, response);
	}
}
