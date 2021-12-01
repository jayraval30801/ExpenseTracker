package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName = request.getParameter("FirstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserDao userdao = new UserDao();
		userdao.updateUser(userId, FirstName, email, password);
		response.sendRedirect("ListUserServlet");
	}
}
