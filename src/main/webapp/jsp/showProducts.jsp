<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Products</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<h1>List of Products</h1>
	<table>
		<tr>
			<th>Product ID</th>
			<th>Description</th>
			<th>Quantity in stock</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.pId}</td>
				<td>${product.pDesc}</td>
				<td>${product.qtyInStock}</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td><a href="/index.html">Home</a></td>
			<td><a href="/addOrder.html">Add Order</a></td>
			<td><a href="/showCustomers.html">List Customers</a></td>
			<td><a href="/showOrders.html">List Orders</a></td>
			<td><a href="<c:url value='/logout'/>">Logout</a></td>
		</tr>
	</table>
</body>
</html>