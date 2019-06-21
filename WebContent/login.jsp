<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="login" method="POST">
       <input type="text" name="user" value="usuario" />
       <input type="password" name="password" value="contraseña" />
       <input type="submit" value="Enviar" />
    </form>
</body>
</html>