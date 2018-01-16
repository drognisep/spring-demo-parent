<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Customer</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h3>Add a New Customer</h3>
	<form:form id="new-customer-form" action="add" method="POST" commandName="customer">
		First Name <form:input path="firstName" placeholder="Enter First Name" />
			<form:errors path="firstName" cssClass="error" /><br/><br/>
		Last Name: <form:input path="lastName" placeholder="Enter Last Name" />
			<form:errors path="lastName" cssClass="error" /><br/><br/>
		Email Address: <form:input type="email" path="email" placeholder="Must be a valid email address" />
			<form:errors path="email" cssClass="error" /><br/><br/>
	</form:form>
	<input type="submit" value="Add Customer" onclick="(function click(event) {document.querySelector('#new-customer-form').submit();})();" />
	<a href="${pageContext.request.contextPath}/customers/list"><button>Cancel New Customer</button></a>
</body>
</html>