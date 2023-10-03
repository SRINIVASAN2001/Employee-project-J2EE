<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
	
	<h1><%String message=(String)request.getAttribute("message"); %></h1>
	<%if(message!=null){%>
		<%= message %>
	<%}%>
	<form action="login">
		email:<input type="text" name="email"><br>
		password:<input type="text" name="password"><br>
		<input type="submit">
	</form>
	<br>
	<br>
	<h3>sign-up for New User</h3>
	<button><a href="signup.jsp">Click me</a></button>
	

</body>
</html>