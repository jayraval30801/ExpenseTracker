package controller;

import java.io.IOException;
import java.util.regex.Pattern;

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
		

				boolean isError = false;
				
				String FirstNamePattern = "^[a-zA-Z]+$";
				Pattern pFn = Pattern.compile(FirstNamePattern);
				if (FirstName == null || FirstName.trim().length() == 0) {
					isError = true;
					request.setAttribute("FirstNameError", "Please Enter FirstName");
				} 
				else if(pFn.matcher(FirstName).matches()== false ) {
					isError = true;
					request.setAttribute("FirstNameError", "Please Enter Only Alphabets in FirstName");
					request.setAttribute("FirstNameValue", FirstName);
				}
				else {
					request.setAttribute("FirstNameValue", FirstName);
				}

				String EmailPattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
				Pattern p = Pattern.compile(EmailPattern);
				
				if (email == null || email.trim().length() == 0) {
					isError = true;
					request.setAttribute("EmailError", "Please Enter Email");
				} else if (p.matcher(email).matches() == false) {
					isError = true;
					request.setAttribute("EmailError", "Please Enter Valid Email");
					request.setAttribute("EmailValue", email);

				} else {
					request.setAttribute("EmailValue", email);
				}

				if (password == null || password.trim().length() == 0) {
					isError = true;
					request.setAttribute("PasswordError", "Please Enter Password");
				} else {
					request.setAttribute("PasswordValue", password);
				}
				
				
				RequestDispatcher rd = null;
				if(isError = true) {
					rd = request.getRequestDispatcher("Signup.jsp");
				}else {
					UserBean userbean = new UserBean();
					userbean.setFirstName(FirstName);
					userbean.setEmail(email);
					userbean.setPassword(password);
					
						UserDao userdao = new UserDao();
					     userdao.insertUser(userbean);	
	
					rd = request.getRequestDispatcher("Dashboard.jsp");
					
					}
		rd.forward(request, response);
				
	}

}
