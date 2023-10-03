<%@page import="employee.Employee_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY PAGE</title>
</head>
<body>
	<%String name=(String)request.getAttribute("name"); %>
	<h1>Hello <%= name %></h1>

	<h2>You have done it!!!!!!!</h2>
	
	<% List<Employee_DTO> employees= (List)request.getAttribute("employees"); %>
	
	<table border="1px solid black" style="border-collapse: collapse;">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Password</th>
			<th>EDIT</th>
			<th>DELETE</th>
			
		</tr>
	</thead>
	
	<%for(Employee_DTO e:employees){ %>
	<tr>
		<td><%= e.getId()%></td>
		<td><%= e.getName()%></td>
		<td><%= e.getEmail()%></td> 
		<td><%= e.getContact()%></td>
		<td><%= e.getPassword()%></td>
		<th><a href="edit?id=<%= e.getId() %>">edit</a></th>
		<th><a href="delete?id=<%= e.getId() %>">delete</a></th>
	</tr>
	<%}%>
	</table>
	<br>
	<br>
	<button><a href="signup.jsp">Add-New Values</a></button>
	<button><a href="signout">Sign-out</a></button>
</body>
</html>