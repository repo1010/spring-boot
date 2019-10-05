<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Shopping Portal</title>
</head>
<body>

	<div class="container">
		<form:form id="product" modelAttribute="product" action="multidelete"
			method="post">
			<div>
				<navbar> 
					<a class="active" href="sowproduct">AddProduct</a> 
				</navbar>
			</div>
			<div>
				<table align="center" class="table">

					<tr>
						
						<th>ProductName</th>
						<th>Cost</th>
						<th>Description</th>
					</tr>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><form:checkbox value="${product.id}" name="id" path="id"/></td>
							<td>${product.name}</td>
							<td>${product.cost}</td>
							<td>${product.description}</td>
							<td><a href="showedit/${product.id}"><img src="https://img.icons8.com/color/48/000000/edit.png"></<a></td>
							<td><a href="deleteproduct/${product.id}"><img src="https://img.icons8.com/color/48/000000/delete-forever.png"></a></td>							
						</tr>
					</c:forEach>
				</table>
					<form:button name="submit" class="btn btn-secondary" id="submit">Multi Delete</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>