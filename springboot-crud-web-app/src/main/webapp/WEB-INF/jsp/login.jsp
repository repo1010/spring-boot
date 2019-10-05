<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>
	<div class="container-fluid">
		<p align="center">
			<a href="">Home</a>
		</p>
		<form:form id="loginForm" modelAttribute="customer"
			action="productportal" method="post">

			<table align="center" class="table">
				<tr class="form-group">
					<td><form:label path="username">Username : </form:label></td>
					<td><form:input path="username" name="username" id="username"
							class="form-control" /></td>
				</tr>
				<tr class="form-group">
					<td><form:label path="password">Password : </form:label></td>
					<td><form:input path="password" name="password" id="password"
							class="form-control" />
				</tr>
				<tr>
					<td></td>
					<td><form:button name="login" id="login"
							class="btn btn-primary">Login</form:button></td>
				</tr>
			</table>

		</form:form>

	</div>

</body>
</html>