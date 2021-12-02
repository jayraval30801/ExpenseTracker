package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId  = request.getParameter("adminId");
		String adminPass = request.getParameter("adminPass");
		
		boolean isError = false;
		if(adminId.equals("7049")) {
			isError = false;
			request.setAttribute("adminIdValue",adminId);
			
		}else if(adminId == null || adminId.trim().length() == 0){
			isError = true;
			request.setAttribute("adminIdError", "Please Enter AdminId Proper ");
		}else {
			isError = true;
			request.setAttribute("adminIdError", "Please Enter Proper ID and Pass");
		}
		if(adminPass.equals("admin")) {
			isError = false;
			request.setAttribute("adminPassValue", adminPass);
		}else if(adminPass == null || adminPass.trim().length() == 0){
			isError = true;
			request.setAttribute("adminPassError", "Please Enter AdminPassword Proper ");
		}else {
			isError = true;
			request.setAttribute("adminPassError", "Please Enter Proper ID and Pass");
		}
		RequestDispatcher rd = null;
		if(isError == true) {
			rd = request.getRequestDispatcher("Admin.jsp");
			
		}else {
			rd = request.getRequestDispatcher("Dashboard.jsp");
			
			request.setAttribute("adminId", adminId);
			request.setAttribute("adminPass", adminPass);
		}
		rd.forward(request, response);
		
	}
}
