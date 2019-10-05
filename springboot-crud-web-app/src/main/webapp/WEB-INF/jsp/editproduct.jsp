<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>



	<div class="container-fluid">
		<p align="center">
			<a href="">Home</a>
		</p>
		<form:form id="product" modelAttribute="product"
			action="/springboot-crud-web-app/addproduct" method="post">

			<table align="center" class="table">
				<tr class="form-group">
					<td></td>
					<td><form:hidden path="id" name="id" id="id"
							class="form-control" /></td>
				</tr>
				<tr class="form-group">
					<td><form:label path="name">Product Name : </form:label></td>
					<td><form:input path="name" name="name" id="name"
							class="form-control" /></td>
				</tr>
				<tr class="form-group">
					<td><form:label path="cost">Cost : </form:label></td>
					<td><form:input path="cost" name="cost" id="cost"
							class="form-control" />
				</tr>
				<tr class="form-group">
					<td><form:label path="description">Description : </form:label></td>
					<td><form:input path="description" name="description"
							id="description" class="form-control" />
				</tr>
				<tr>
					<td></td>
					<td><form:button name="addproduct" id="addproduct"
							class="btn btn-primary">Save</form:button></td>
				</tr>
			</table>

		</form:form>

	</div>
</body>
</html>