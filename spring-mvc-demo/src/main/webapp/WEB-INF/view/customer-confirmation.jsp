<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
	Customer confirmed: ${customer.lastName}, ${customer.firstName}<br/>
	Free Passes: ${customer.freePasses}<br/>
	US Postal Code: ${customer.postalCode}<br/>
	Customer Email: ${customer.email}<br/>
	Course Code: ${customer.courseCode}
	<hr />
	<a href="${pageContext.request.contextPath}/">Back to main menu</a><br/>
	<a href="${pageContext.request.contextPath}/customer/showForm">Add another Customer</a>
</body>
</html>