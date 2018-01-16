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
	<h3>Update the Customer ${customer.lastName}, ${customer.firstName}</h3>
	<form:form id="update-customer-form" action="${pageContext.request.contextPath}/customers/update/${customer.id}" method="POST" commandName="customer">
		First Name <form:input path="firstName" value="${customer.firstName}" />
			<form:errors path="firstName" cssClass="error" /><br/><br/>
		Last Name: <form:input path="lastName" value="${customer.lastName}" />
			<form:errors path="lastName" cssClass="error" /><br/><br/>
		Email Address: <form:input type="email" path="email" value="${customer.email}" />
			<form:errors path="email" cssClass="error" /><br/><br/>
	</form:form>
	<input type="submit" value="Update Customer" onclick="(function click(event) {document.querySelector('#update-customer-form').submit();})();" /><a href="${pageContext.request.contextPath}/customers/list"><button>Cancel Update</button></a>
</body>
</html>