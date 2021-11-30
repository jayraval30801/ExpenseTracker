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
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>


		<%
			while (rs.next()) {
				int userId = rs.getInt("userId");
				String FirstName = rs.getString("FirstName");
				String email = rs.getString("email");
				String password = rs.getString("password");
		%>
		<tr>
			<td><%=userId%></td>
			<td><%=FirstName%></td>
			<td><%=email%></td>
			<td><%=password%></td>
			<td><a href="DeleteUserServlet?userId=<%=userId%>">Delete</a>
			<a href="ViewUserServlet?userId=<%=userId%>">View</a></td>
			
		</tr>

		<%
			}
		%>
	</table>
	

</body>
</html>