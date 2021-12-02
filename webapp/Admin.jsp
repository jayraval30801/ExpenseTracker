<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<form action="AdminServlet">
Enter Admin Id=<input type="number" name="adminId" value="${adminIdValue}" />${adminIdError}<br>
Enter Admin Password=<input type="password" name="adminPass" value="${adminPassValue}"> ${adminPassError}<br>
<input type="submit" value="Login">
</form>

</body>
</html>