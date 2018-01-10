<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Demo - Form Response</title>
</head>
<body>
	<h2><span style="color:red;background-color:black;padding-left:8px;padding-right:8px;">Hell</span> World of Spring</h2>
	<h4>Student Name: ${message}</h4>
	<a href="${pageContext.request.contextPath}/">Back to Menu</a>
</body>
</html>