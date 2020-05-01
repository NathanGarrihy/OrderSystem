<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--  https://stackoverflow.com/questions/9067214/unknown-spring-tags -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Customer</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<h1>Add New Customer</h1>
	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>Cust Name:</td>
				<td><form:input path="cName"></form:input></td>
			</tr>
		</table>
		<input type="submit" value="add" />
		<table>
			<tr>
				<td><a href="/index.html">Home</a></td>
				<td><a href="/showOrders.html">List Orders</a></td>
				<td><a href="w/showProducts.html">List Products</a></td>
				<td><a href="<c:url value='/logout'/>">Logout</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>