<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="resources/css/estilo.css" />
	
</head>
<body class="container">
 <!-- navbar -->
 <jsp:include page="../Componentes/navbar.jsp" />
 <h1 class="text-center mt-fixed-nav" id="">LISTADO DE CUSTOMER</h1>
 <container class="col-10 offset-1">
     <table class="table table-striped text-center col-10" id="table_customer">
      <thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Update</th>
				<th>Delete</th>
				
			</tr>
	  </thead>
	   <tbody>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customer_id}</td>
				<td>${customer.first_name}</td>
				<td>${customer.last_name}</td>
				<td>${customer.email}</td>
				<td>${customer.mobile}</td>
				<td>
					<form action="<c:url value="/addCustomer"/>" method="POST">
	                           <input type="hidden" name="option" value="update_redirect"><!-- input oculto -->
	                           <input type="hidden" name="customer_id" value="${customer.customer_id}"><!-- input oculto -->
	                           <input type="hidden" name="first_name" value="${customer.first_name}"><!-- input oculto -->
	                           <input type="hidden" name="last_name" value="${customer.last_name}"><!-- input oculto -->
	                           <input type="hidden" name="email" value="${customer.email}"><!-- input oculto -->
	                           <input type="hidden" name="mobile" value="${customer.mobile}"><!-- input oculto -->
	                           <input type="submit" value="Update" class="btn btn-outline-success col-12">
					</form>
				</td>
				<td>
					<form action="<c:url value="/addCustomer"/>" method="POST">
	                           <input type="hidden" name="option" value="delete_redirect"><!-- input oculto -->
	                           <input type="hidden" name="customer_id" value="${customer.customer_id}"><!-- input oculto -->
	                           <input type="hidden" name="first_name" value="${customer.first_name}"><!-- input oculto -->
	                           <input type="submit" value="delete" class="btn btn-outline-danger col-12">
					</form>
				</td>
			</tr>
		</c:forEach>
		 </tbody>
	</table>
  </container>
  <script>
            $(document).ready(function() {
            $('#table_customer').DataTable( {
                "language": {
                    "lengthMenu": "Mostrar _MENU_ ",
                    "zeroRecords": "Datos no encontrados - upss",
                    "info": "Mostar páginas _PAGE_ de _PAGES_",
                    "infoEmpty": "Datos no encontrados",
                    "infoFiltered": "(Filtrados por _MAX_ total registros)",
                    "search":         "Buscar:",
                    "paginate": {
                            "first":      "First",
                            "last":       "Anterior",
                            "next":       "Siguiente",
                            "previous":   "Anterior"
                    },
                    
                }
            } );
            } );
           
        </script>
  
</body>
</html>