<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Signup</title>
</head>
<body>

		<form action="AddUserServlet" method="post">
			FirstName= <input type="text" name="FirstName"><br>
			Email= <input type="text" name="email"><br>
			Password = <input type="password" name="password"> <br>
			<input type="submit" value="Signup">
			
		</form>
</body>
</html>	