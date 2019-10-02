<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>
	Login Page
	<p align="center">
		<a href="">Home</a>
	</p>
	<form:form id="loginForm" modelAttribute="customer" action="processlogin"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="username">Username : </form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password : </form:label></td>
				<td><form:input path="password" name="password" id="password" />
			</tr>
			<tr>
			<td></td>
			<td><form:button name="login" id="login">Login</form:button></td>
			</tr>
		</table>

	</form:form>



</body>
</html>