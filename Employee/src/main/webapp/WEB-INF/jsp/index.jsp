<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<style>
#log{
margin-top: 1%;
}
</style>
<body>

 <div class="container">
  <h2>Welcome to Employee Management</h2>
  <spring:url value="/admin/inPage/" var="listURL" />
  <a class="btn btn-primary" href="${listURL}" role="button" >Sign Up</a>
 </div> 

<div class="container" id="log">
  <spring:url value="/admin/emplogin" var="listURL" />
  <a class="btn btn-primary" href="${listURL}" role="button" >Login</a>
 </tr>
 </div>

</body>
</html>