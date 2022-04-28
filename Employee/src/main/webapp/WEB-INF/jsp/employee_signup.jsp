<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import = "java.util.Date" %>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
 
 
</head>
<style>
.error {
    color: red;
    font-style: italic;
}
#submit{
margin-left: 16%;
}

</style>
<body>
<div class="container">
  <spring:url value="/admin/inPage" var="saveURL" />
  <h2>
  Employee Sign Up
  
  </h2>
  <br>
 
  
  <form:form id="employeeId" modelAttribute="employeeSignUpForm" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="id"/>
   
   <div class="row">
   <div  class="col-sm-6">
   <div class="form-group">
    <label>Employee FirstName</label>
    <form:input path="fname" cssClass="form-control" id="fname" />
    <form:errors path="fname" cssClass="error" />
   </div>
   </div>
   </div>
   
   <div class="row">
   <div  class="col-sm-6">
   <div class="form-group">
    <label>Employee LastName</label>
    <form:input path="lname" cssClass="form-control" id="lname" />
    <form:errors path="lname" cssClass="error" />
   </div>
   </div>
   </div>
   
   
   <div class="row">
   <div  class="col-sm-6">
   <div class="form-group">
    <label>Employee Email</label>
    <form:input path="email" cssClass="form-control" id="email" />
    <form:errors path="email" cssClass="error" />
   </div>
   </div>
   </div>
   <div class="row">
   <div  class="col-sm-6">
   <div class="form-group">
    <label>Password</label>
    <form:input type="password" path="password" cssClass="form-control" id="password" />
    <form:errors path="password" cssClass="error"/><br><br>
   </div>
   </div>
   </div>
   
   
   <%-- <div class="row">
   <div  class="col-sm-6">
   <div class="form-group">
    <label>Employee Address</label>
    <form:input path="address.add" cssClass="form-control"/>
   </div>
   </div>
   </div> --%>
   
   <button type="submit" id="submit" class="btn btn-primary">Save</button>
 <spring:url value="/cancelInsertOrUpdate" var="cancelURL" />
  <a class="btn btn-primary" href="${cancelURL}" role="button" >Cancel</a>
  </form:form>
  </div>
	
</body>
</html>