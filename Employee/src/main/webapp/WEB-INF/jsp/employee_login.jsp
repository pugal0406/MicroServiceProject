<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.Date"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<h2>Welcome to Login Page</h2>
<br>

</head>

<style>
body.ex1 {
	margin-left: 35%;
}

#username {
	margin-left: 3%;
}

#password {
	margin-left: 5%;
}

#ln {
	margin-left: 18%;
}
</style>

<body class="ex1">

	<div class="container">
		<spring:url value="/admin/emplogin" var="saveURL" />

		<form:form modelAttribute="employeelogin" method="post"
			action="${saveURL }" cssClass="form">
			<%--    <form:hidden path="id"/> --%>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>User Name</label> <input type="text" name="username"
							cssClass="form-control" id="username" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							cssClass="form-control" id="password" />
					</div>
				</div>
			</div>

			<!--  <div class="row">
   <div  class="col-sm-6">
   <a href="/forgotPassword">forgotPassword</a>
   </div>
   </div> -->

			<button type="submit" id="ln" class="btn btn-primary">Login</button>
		</form:form>
	</div>

</body>
</html>