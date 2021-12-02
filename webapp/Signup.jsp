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
			FirstName= <input type="text" name="FirstName" value="${FirstNameValue}"/>${FirstNameError}<br>
			Email= <input type="text" name="email" value="${EmailValue}"/>${EmailError}<br>
			Password = <input type="password" name="password" value="${PasswordError}"/>${PasswordError}<br>
			<input type="submit" value="Signup">
			
		</form>
</body>
</html>	