<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Form</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>Fill out the form.</h2>
	<form:form action="processForm" modelAttribute="customer">
		First Name <span class="error">*</span>: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br />
		<br />
		Last Name <span class="error">*</span>: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
		<br />
		Free Passes <span class="error">*</span>: <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		<br />
		<br />
		US Postal Code <span class="error">*</span>: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br />
		<br />
		Customer Email <span class="error">*</span>: <form:input type="email" path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		<br />
		Course Code <span class="error">*</span>: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />
		<br />
		<br />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>