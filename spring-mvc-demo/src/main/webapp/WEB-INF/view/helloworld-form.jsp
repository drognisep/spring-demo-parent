<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Demo - Form</title>
</head>
	<body>
		<form method="get" action="processForm">
			<input type="text" name="studentName" placeholder="Enter the student name here"/>
			<input type="submit" />
		</form>
		<a href="${pageContext.request.contextPath}/">Back to Menu</a>
	</body>
</html>