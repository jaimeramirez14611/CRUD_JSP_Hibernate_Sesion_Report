<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Customer</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   
	<style type="text/css">
	#frmCustomer{
	    border: 1px solid silver; 
	    padding:1%;
	    padding-right:2%;
	    border-radius: 5px;
	    background-color: white;
	    color: black; 
	}
	body{
	    background-color: #FDFDFD;
	}
	.mt-fixed-nav{
	    margin-top:10% !important;
	}
	.bg-secondary{
	  color: white !important;
	}

</style>
</head>
<body class="container">
      <jsp:include page="../Componentes/navbar.jsp" />
      
      <h1 class="text-center mt-fixed-nav">AGREGAR CUSTOMER</h1>
     
       
      <%  
        //String respuesta = request.getParameter("datos");
        //out.print(respuesta);   
        String html = "<section class='alert alert-primary col-4 offset-4 text-center ' role='alert' id='alerta'>";
        out.print(html);  
      %>
      <span>${datos}</span>
      <%
      String resp2 = "</section>;";
      out.print(resp2); 
      %>
       
      
      <section>
           <form action="/CRUD_JSP_Hibernate_Sesion_Report/addCustomer" method="POST" class="col-8 offset-2" id="frmCustomer">
		  		<section class="form-group row">
				    <label  class="col-2">Nombres</label>
				    <input type="text" class="form-control col-10" id="firs_name" name="first_name">
				</section >
				<section class="form-group row">
				    <label  class="col-2">Apellidos</label>
				    <input type="text" class="form-control col-10" id="last_name" name="last_name">
				</section >
				<section  class="form-group row">
				    <label  class="col-2">Email:</label>
				    <input type="email" class="form-control col-10" id="email" name="email">
				</section>
				<section  class="form-group row">
				    <label  class="col-2">Telefono:</label>
				    <input type="number" class="form-control col-10" id="mobile" name="mobile">
				</section>
				
				<input type="submit" class="btn btn-outline-success col-2 offset-4" value="Guardar">
				<input type="reset" class="btn btn-outline-danger col-2" value="Reset">
	     </form>
      </section>
	  <script type="text/javascript">
	  //Oculta la seccion despues de x tiempo
	  let stateCheck = setInterval(() => {
		  if (document.readyState === 'complete') {
		    clearInterval(stateCheck);
		    // document ready
		    var el = document.getElementById("alerta");
		    el.style.display = (el.style.display == 'none') ? 'block' : 'none';
		  }
		}, 10000);
	   console.log(stateCheck+"pp");
      </script>
</body>
</html>