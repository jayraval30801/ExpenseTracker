package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
int userId = Integer.parseInt(request.getParameter("userId"));
		
		UserDao studentDao = new UserDao();
		
		ResultSet rs = studentDao.getUserById(userId);
		request.setAttribute("rs", rs);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewUser.jsp");
		rd.forward(request, response);
		
	}
	
}
