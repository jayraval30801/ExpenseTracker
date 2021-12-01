<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
		rs.next(); //1st record 
		int categoryId = rs.getInt("categoryId");
		String categoryName = rs.getString("categoryName");
		String subcategoryName = rs.getString("subcategoryName");
		String expense = rs.getString("expense");
	
	%>
	<h2>Category</h2>

			<b>CategoryId</b> :<%=categoryId%><br>
			<b>CategoryName</b> :<%=categoryName%><br>
			<b>SubCategoryName</b> :<%=subcategoryName%><bR>
			<b>Expense</b> :<%=expense%><br>
	<a href="ListCategoryServlet">Back</a>
	<a href="UpdateCategoryServlet?categoryId=<%=categoryId%>">Update Category</a>
 		
</body>
</html>