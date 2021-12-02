<%@page import="bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<CategoryBean> category = (ArrayList<CategoryBean>) request.getAttribute("category");

	%>
	<%
	if(category.size()==0){
		out.println("List is Empty");
	}
	else{
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
			for (int i = 0; i < category.size(); i++) {
		%>
	
			
		<tr>
			<td><%=category.get(i).getCategoryId()%></td>
			<td><%=category.get(i).getCategoryName()%></td>
			<td><%=category.get(i).getSubcategoryName()%></td>
			<td><%=category.get(i).getExpense()%></td>
			<td><a href="DeleteCategoryServlet?categoryId=<%=category.get(i).getCategoryId()%>">Delete</a>
			<a href="EditCategoryServlet?categoryId=<%=category.get(i).getCategoryId()%>">Edit</a></td>
			
		</tr>	
		<%
			}
	}
		%>
		<a href="Dashboard.jsp">Back to Dashbord</a>

</body>
</html>