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
	
	<form action="UpdateUserServlet" method="post">
	FirstName=<input type="text" name="FirstName" value="<%=rs.getString("FirstName") %>"/><br>
	Email = <input type="text" name="email" value="<%=rs.getString("email") %>"/><br>
	Password = <input type="password" name="password" value="<%=rs.getString("password") %>"/><br>
	<input type="hidden" name="userId" value="<%=rs.getInt("userId") %>"/>
	<input type="submit" value="update User"/>
	
	</form>
	
</body>
</html>