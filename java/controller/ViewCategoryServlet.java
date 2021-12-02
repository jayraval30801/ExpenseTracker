package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;

@WebServlet("/ViewCategoryServlet")
public class ViewCategoryServlet extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	
	CategoryDao catDao = new CategoryDao();
	
	ResultSet rs = catDao.getCategoryById(categoryId);
	request.setAttribute("rs", rs);
	
	
	RequestDispatcher rd = request.getRequestDispatcher("ViewCategory.jsp");
	rd.forward(request, response);	

}
}
