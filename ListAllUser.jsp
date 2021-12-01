<%@page import="bean.UserBean"%>
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
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>
	

	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>
	
	<%
			for (int i = 0; i < users.size(); i++) {
		%>
	

		<tr>
			<td><%=users.get(i).getUserId()%></td>
			<td><%=users.get(i).getFirstName()%></td>
			<td><%=users.get(i).getEmail()%></td>
			<td><%=users.get(i).getPassword()%></td>
			<td><a href="DeleteUserServlet?userId=<%=users.get(i).getUserId()%>">Delete</a>
			<a href="EditUserServlet?userId=<%=users.get(i).getUserId()%>">Edit</a></td>
			
		</tr>

		<%
			}
		%>
	</table>
	

</body>
</html>