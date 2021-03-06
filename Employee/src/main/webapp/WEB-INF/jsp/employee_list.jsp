<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
 <script type="text/javascript">
 function fn(obj){
	 if(obj!=null){
		 alert(" deleted sucessfully!"); 
	 }else{
		 return false;
	 }
	
 }
 </script>
</head>
<body>



 <div class="container">
   <h2>Employee List</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">ID</th>
    <th scope="row">Name</th>
    <!-- <th scope="row">Email</th>  -->   
    <th scope="row">Address</th>
    <th scope="row">Phone</th>
    <th scope="row">Gender</th>
    <th scope="row">Course</th>
    <th scope="row">Designation</th>
    <th scope="row">Joining Date</th>
    <th scope="row">Update</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${employees }" var="employee" >
     <tr>
      <td>${employee.id }</td>
      <td>${employee.name }</td>
     <%--  <td>${employee.email }</td> --%>
      <td>${employee.address }</td>
      <td>${employee.phone }</td>
      <td>${employee.sex }</td>
      <td>${employee.course }</td>
      <td>${employee.department }</td>
      <td>${employee.joiningDate }</td>
      <td>
       <spring:url value="/employee/update/${employee.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
      </td>
      <td>
       <spring:url value="/employee/delete/${employee.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" id="editId" onclick="fn(${employee.id })">Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/employee/insertPage/" var="addURL" />
  <a class="btn btn-primary" href="${addURL}" role="button" >Add Employee Details</a>
 <spring:url value="/employee/logout" var="logURL" />
  <a class="btn btn-primary" href="${logURL}" role="button" >LogOut</a>
 
 </div>

</body>
</html>