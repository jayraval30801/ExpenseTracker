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
	ResultSet rs = (ResultSet)request.getAttribute("rs");
	rs.next();
	
	%>
	<form action="UpdateCategoryServlet" method="post">
	CategoryName=<input type="text" name="categoryName" value="<%=rs.getString("categoryName") %>"/><br>
	SubCategoryName = <input type="text" name="subcategoryName" value="<%=rs.getString("subcategoryName") %>"/><br>
	Expense = <input type="text" name="expense" value="<%=rs.getString("expense") %>"/><br>
	<input type="hidden" name="categoryId" value="<%=rs.getInt("categoryId") %>"/>
	<input type="submit" value="update category"/>
	
	</form>

</body>
</html>