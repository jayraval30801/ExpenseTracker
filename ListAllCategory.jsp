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
	%>

	<table border="1">
		<tr>
			<th> No. </th>
			<th> Category Name </th>
			<th> Subcategory Name </th>
			<th> Expense </th>
			<th>Action</th>
		</tr>


		<%
			while (rs.next()) {
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");
				String subcategoryName = rs.getString("subcategoryName");
				String expense = rs.getString("expense");
		%>
		<tr>
			<td><%=categoryId%></td>
			<td><%=categoryName%></td>
			<td><%=subcategoryName%></td>
			<td><%=expense%></td>
			<td><a href="DeleteCategoryServlet?categoryId=<%=categoryId%>">Delete</a>
			<a href="ViewCategoryServlet?categoryId=<%=categoryId%>">View</a></td>
			
		</tr>	
		<%
			}
		%>
		<a href="Dashboard.jsp">Back to Dashbord</a>

</body>
</html>