<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<script type="text/javascript">
		function confirmDelete(e, formId) {
			e.preventDefault();
			var response = confirm("Are you sure you want to delete this customer?");
			if(response) {
				var f = document.querySelector('#' + formId);
				f.submit();
			}
		}
	</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/customers/add"><button>Add a New Customer</button></a>
	
	<table style="width:100%;margin-top:21.440px;">
		<tr><th>First Name</th><th>Last Name</th><th>Email Name</th><th>Action</th></tr>
		<c:if test="${empty customers}">
			<tr><td colspan="4" style="text-align: center;font-weight:bold;">No Customers Found</td></tr>
		</c:if>
		<c:forEach var="c" items="${customers}">
			<tr><td>${c.firstName}</td><td>${c.lastName}</td><td><a href="mailto:${c.email}">${c.email}</a></td>
				<td>
					<a href="update/${c.id}">Update</a> - 
					<form style="display:inline" id="delete-${c.id}" action="${pageContext.request.contextPath}/customers/delete/${c.id}" method="POST">
						<a href="#" onclick="confirmDelete(event, 'delete-${c.id}')">Delete</a>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>