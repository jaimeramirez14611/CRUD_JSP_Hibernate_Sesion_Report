<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
<body>
   <% 
	  // response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	   //response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   %>
   <jsp:include page="Views/Componentes/navbar.jsp" />
   <h1 class="mt-fixed-nav">Bienvenido  ${sessionScope.usuario}</h1>
   
   <form action="/Crud_JSP_Hibernate/login" method="get">
         <input type="submit" value="out" name="action">
   </form>
</body>
</html>