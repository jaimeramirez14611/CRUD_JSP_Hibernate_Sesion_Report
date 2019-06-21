<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <%
           String redirectURL = "http://localhost:8080/CRUD_JSP_Hibernate_Sesion_Report/addCustomer?action=add";
           response.sendRedirect(redirectURL);
      %>
      
</body>
</html>