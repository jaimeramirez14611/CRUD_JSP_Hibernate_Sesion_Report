<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
     <table class="table table-striped text-center">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customer_id}</td>
				<td>${customer.first_name}</td>
				<td>${customer.last_name}</td>
				<td>${customer.email}</td>
				<td>${customer.mobile}</td>
				<td>
				<form action="<c:url value="/addCustomer"/>" method="POST">
                           <input type="hidden" name="option" value="updateredirect"><!-- input oculto -->
                           <input type="hidden" name="customer_id" value="${customer.customer_id}"><!-- input oculto -->
                           <input type="hidden" name="first_name" value="${customer.first_name}"><!-- input oculto -->
                           <input type="hidden" name="last_name" value="${customer.last_name}"><!-- input oculto -->
                           <input type="hidden" name="email" value="${customer.email}"><!-- input oculto -->
                           <input type="hidden" name="mobile" value="${customer.mobile}"><!-- input oculto -->
                           <input type="submit" value="Update" class="btn btn-outline-success">
				</form>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>