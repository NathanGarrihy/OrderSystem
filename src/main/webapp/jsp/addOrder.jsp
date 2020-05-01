<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--  https://stackoverflow.com/questions/9067214/unknown-spring-tags -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Order</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<h1>Add New Order</h1>
	<form:form modelAttribute="order">

		<tr>
			<td>Customer:</td>
			<form:select path="cust" items="${customerList}" />
		</tr>
		<br />
		<tr>
			<td>Product:</td>
			<td><form:select path="prod" items="${productList}" /></td>
		</tr>
		<br />
		<tr>
			<td>Quantity:</td>
			<td><form:input path="qty"></form:input></td>
		</tr>

		<input type="submit" value="add" />

		<br />
		<tr>
			<td><a href="/index.html">Home</a></td>
			<td><a href="/showOrders.html">List Orders</a></td>
			<td><a href="/showProducts.html">List Products</a></td>
			<td><a href="<c:url value='/logout'/>">Logout</a></td>
		</tr>


	</form:form>
</body>
</html>