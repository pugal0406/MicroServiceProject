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


</head>

<style>
.error {
	color: red;
	font-style: italic;
}

#but {
	margin-left: 11%;
}
</style>

<body>

	<div class="container">
		<spring:url value="/employee/insertPage" var="saveURL" />
		<h2>Employee</h2>

		<script type="text/javascript">
			$(function() {
				$("#joiningDate").datepicker();
				$("#upload-file-input").on("change", uploadFile);
				
				
				function uploadFile() {
					alert("called"); 
					$.ajax({
					    url: "/employee/uploadFile",
					    type: "POST",
					    data: new FormData($("#empId")[0]),
					    enctype: 'multipart/form-data',
					    processData: false,
					    contentType: false,
					    cache: false,
					    success: function () {
					      // Handle upload success
					      // ...
					    },
					    error: function () {
					      // Handle upload error
					      // ...
					    }
					  });
					}		
				
			});
		</script>

		<form:form id="empId" modelAttribute="employeeForm" method="post"
			action="${saveURL }" cssClass="form" encType="multipart/form-data">
			<form:hidden path="id" />

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>Name</label>
						<form:input path="name" cssClass="form-control" id="name" />
						<form:errors path="name" cssClass="error" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>Address</label>
						<form:input path="address" cssClass="form-control" id="address" />
						<form:errors path="address" cssClass="error" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>Phone</label>
						<form:input path="phone" cssClass="form-control" id="phone" />
						<form:errors path="phone" cssClass="error" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label>Gender: </label>
				<form:radiobutton path="sex" value="M" />
				Male
				<form:radiobutton path="sex" value="F" />
				Female
				<form:errors path="sex" cssClass="error" />
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>Course: </label> B.Tech
						<form:checkbox path="course" value="B.Tech"
							style="margin-left: 1%;" />
						BSC
						<form:checkbox path="course" value="BSC" style="margin-left: 1%;" />
						MBA
						<form:checkbox path="course" value="MBA" style="margin-left: 1%;" />

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>Designation: </label>
						<form:select path="department" id="department"
							class="form-control input-sm">
							<form:option value="">Select Designation</form:option>
							<form:options items="${department}" />
						</form:select>
						<form:errors path="department" cssClass="error" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>Date Of Joining: </label> <br>
				<form:input type="text" path="joiningDate" />
				<br>
				<form:errors path="joiningDate" cssClass="error" />
			</div>

		<!-- 	  <div class="form-group">
   <label for="upload-file-input">Upload your file:</label>
    <input id="upload-file-input" type="file" name="fileUpload" accept="*" onclick="uploadFile()"/>
   </div>  -->

			<div id="but">
				<button type="submit" id="but" class="btn btn-primary">Save</button>
				<spring:url value="/cancelInsertOrUpdate" var="cancelURL" />
				<a class="btn btn-primary" href="${cancelURL}" role="button">Cancel</a>
			</div>
		</form:form>
	</div>

</body>
</html>