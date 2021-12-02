package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryBean;
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
		ArrayList<CategoryBean> category = catdao.getAllCategory();
		request.setAttribute("category", category);
		RequestDispatcher rd = request.getRequestDispatcher("ListAllCategory.jsp");
		rd.forward(request, response);
	
	}
}
