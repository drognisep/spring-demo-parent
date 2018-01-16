<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<jsp:include page="../includes/app-style.jsp" />
</head>
<body>
	<div style="width:90%;margin-left:5%;">
		<jsp:include page="../includes/top-frame.jsp" />
		<jsp:include page="#{viewName}.jsp" />
	</div>
</body>
</html>