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


@WebServlet("/ListCategoryServlet")
public class ListCategoryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao catdao = new CategoryDao();
		ResultSet rs = 	catdao.getAllCategory();
		request.setAttribute("rs", rs);
		RequestDispatcher rd = request.getRequestDispatcher("ListAllCategory.jsp");
		rd.forward(request, response);
	
	}
}
