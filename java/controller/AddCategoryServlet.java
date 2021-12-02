package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryBean;
import dao.CategoryDao;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryName = request.getParameter("categoryName");
		String subcategoryName = request.getParameter("subcategoryName");
		String expense = request.getParameter("expense");
		
		CategoryBean categorybean = new CategoryBean();
		categorybean.setCategoryName(categoryName);
		categorybean.setSubcategoryName(subcategoryName);
		categorybean.setExpense(expense);
		
		CategoryDao catdao = new CategoryDao();
			
		catdao.insertCategory(categorybean);
			
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			rd.forward(request, response);
	}
	
}
	
