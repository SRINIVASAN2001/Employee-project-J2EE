<%@page import="employee.Employee_DTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT PAGE</title>
</head>
<body>
	<% Employee_DTO e=(Employee_DTO)request.getAttribute("emp"); %>
	
	<form action="update">
	<input type="text" value="<%= e.getId() %>" name="id" readonly="true">
	<input type="text" value="<%= e.getName() %>" name="name">
	<input type="text" value="<%= e.getEmail() %>" name="email">
	<input type="text" value="<%= e.getContact() %>" name="contact">
	<input type="text" value="<%= e.getPassword() %>" name="password">
	<input type="submit">
	
	</form>
</body>
</html>