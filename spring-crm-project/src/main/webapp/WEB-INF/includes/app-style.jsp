<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style>
* {
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}
table {
	margin-top: 21.440px;
}
table, tbody {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
table th, table td, table tr {
	margin: 0;
	box-sizing: border-box;
}
table tr:first-child() {
	background-color: green;
	color: white;
}
table th {
	background-color: green;
	color: white;
	padding: 8px 16px;
}
table tr:nth-child(odd) {
	background-color: #ccc;
}
table td {
	text-align: center;
}
input[type="submit"],
button {
	cursor: pointer;
}
</style>