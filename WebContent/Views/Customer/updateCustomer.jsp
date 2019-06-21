<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- https://www.ecodeup.com/como-usar-la-libreria-jstl-en-paginas-jsp/ -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Customer</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/estilo.css" />
</head>
<body class="container">
      <!-- navbar -->
      <jsp:include page="../Componentes/navbar.jsp" />
      
      <h1 class="text-center mt-fixed-nav">MODIFICAR CUSTOMER</h1>
      
      <!-- Validacion de mensaje de error -->
      <c:if test="${error != null}">
        	<c:out value="<section class='alert alert-danger col-4 offset-4 text-center ' role='alert' id='alerta'> ${error} </section>" escapeXml="false"></c:out>
      
      <!-- Validacion de mensaje de dato agregado -->
      </c:if>
      
      <c:if test="${success != null}">
        	<section class="alert alert-success col-4 offset-4 text-center" role="alert" id="alerta"> ${success} </section>
        	<a  class="btn btn-outline-success text-center col-4 offset-4" href="http://localhost:8080/CRUD_JSP_Hibernate_Sesion_Report/addCustomer?action=list">Retornal a la lista principal</a>
      </c:if>
      <c:if test="${success == null}">
	      <section>
	           <form action="/CRUD_JSP_Hibernate_Sesion_Report/addCustomer" method="POST" class="col-8 offset-2" id="frmCustomer">
			  		<c:forEach items="${datos}" var="customer">
	                     
		                <section class="form-group row">
						    <label  class="col-2">Nombres</label>
						    <input type="hidden" class="form-control col-10" value="${customer.customer_id }" name="customer_id">
						    <input type="hidden" value="update_data" name="option">
						    <input type="text" class="form-control col-10" value="${customer.first_name}" name="first_name">
						</section >
						<section class="form-group row">
						    <label  class="col-2">Apellidos</label>
						    <input type="text" class="form-control col-10" value="${customer.last_name }" name="last_name">
						</section >
						<section  class="form-group row">
						    <label  class="col-2">Email:</label>
						    <input type="email" class="form-control col-10" value="${customer.email}" name="email">
						</section>
						<section  class="form-group row">
						    <label  class="col-2">Telefono:</label>
						    <input type="number" class="form-control col-10" value="${customer.mobile}" name="mobile">
						</section>         	
	                </c:forEach>
					<input type="submit" class="btn btn-outline-success col-2 offset-4" value="Guardar">
					<input type="reset" class="btn btn-outline-danger col-2" value="Reset">
		     </form>
	      </section>
       </c:if>
      <!-- Ocultar alert -->
	  <script type="text/javascript" src="resources/js/hideAlert.js" ></script>
</body>
</html>