package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;

@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;



protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	String categoryName = request.getParameter("categoryName");
	String subcategoryName = request.getParameter("subcategoryName");
	String expense = request.getParameter("expense");
	CategoryDao catDao = new CategoryDao();
	catDao.updateCategory(categoryId,categoryName,subcategoryName,expense);	
	response.sendRedirect("UpdateCategory.jsp"); 
		
}
	
}
