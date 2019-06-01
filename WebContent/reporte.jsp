<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="java.util.*" %>  
<%@ page import="java.io.File" %>   
<%@ page import="java.sql.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%
    try{
     String jrxmlFile = application.getRealPath("/Reportes/Blank_A4.jrxml");
     Connection con = null;
     String sURL = "jdbc:mysql://localhost:3306/sistema";
     con = DriverManager.getConnection(sURL,"root","");
    
     JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile);
    }catch(Exception e){
    	out.print(e);
    }
     
     
   
   
   
   %>
</body>
</html>