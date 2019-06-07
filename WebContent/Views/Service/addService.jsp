<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/estilo.css" />  
</head>
<body>
     <!-- navbar -->
     <jsp:include page="../Componentes/navbar.jsp" />
      <h1 class="text-center mt-fixed-nav">AGREGAR SERVICE</h1>
      <!-- Validacion de mensaje de error -->
      <c:if test="${error != null}">
        	<c:out value="<section class='alert alert-danger col-4 offset-4 text-center ' role='alert' id='alerta'> ${error} </section>" escapeXml="false"></c:out>
      
      <!-- Validacion de mensaje de dato agregado -->
      </c:if>
      
      <c:if test="${success != null}">
        	<c:out value="<section class='alert alert-success col-4 offset-4 text-center ' role='alert' id='alerta'> ${success} </section>" escapeXml="false"></c:out>
      </c:if>
      <section>
           <form action="/CRUD_JSP_Hibernate_Sesion_Report/addService" method="POST" class="col-8 offset-2" id="frmService">
		  		<section class="form-group row">
				    <label  class="col-2">Servcio</label>
				    <select class="form-control col-10" name="service">
				          <option selected="selected">
				          </option>
						  <option value="TV_Satelital">TV_Satelital</option>
						  <option value="FM_radio">FM_radio</option>
						  <option value="HT_hostpot">HT_hostpot</option>
					</select>
				  
				</section >
				<section class="form-group row">
				    <label  class="col-2">Descripción</label>
				    <textarea  class="form-control col-10" id="last_name" name="description"></textarea>
				</section >
				<section class="form-group row">
				    <label  class="col-2">Usuario Code</label>
				    <input type="number" class="form-control col-10"  name="customer">
				</section>
				
				<input type="submit" class="btn btn-outline-success col-2 offset-4" value="Guardar">
				<input type="reset" class="btn btn-outline-danger col-2" value="Reset">
	     </form>
      </section>
     <!-- Ocultar alert -->
	 <script type="text/javascript" src="resources/js/hideAlert.js" />
</body>
</html>