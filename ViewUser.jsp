<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View user</title>
</head>
<body>
	
	<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
		rs.next(); //1st record 
		int userId = rs.getInt("userId");
		String FirstName = rs.getString("FirstName");
		String email = rs.getString("email");
		String password = rs.getString("password");
	
	%>
	<h2>View User</h2>

			<b>UserId</b> :<%=userId%><br>
			<b>FirstName</b> :<%=FirstName%><br>
			<b>Email</b> :<%=email%><bR>
			<b>Password</b> :<%=password%><br>
	<a href="ListUserServlet">Back</a>
	<a href="UpdateUserServlet">Update User</a>
 		
</body>
</html>