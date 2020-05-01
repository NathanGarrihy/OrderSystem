<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--  https://stackoverflow.com/questions/9067214/unknown-spring-tags -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Customers</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<h1>List of Customers</h1>
	<c:forEach items="${customers}" var="customer">
		<h2>${customer.cId}${customer.cName}</h2>
		<h3 style="text-align: left">${customer.cName}'sOrders</h3>
		<table>
			<tr style="text-align: left">
				<th>Order ID</th>
				<th>Quantity</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>

			<c:forEach items="${customer.orders}" var="order">
				<tr style="text-align: left">
					<td>${order.oId}</td>
					<td>${order.qty}</td>

					<td>${order.prod.pId}</td>
					<td>${order.prod.pDesc}</td>
				</tr>

			</c:forEach>
		</table>
	</c:forEach>
	<br />

	<table>
		<tr>
			<td><a href="/index.html">Home</a></td>
			<td><a href="/addCustomer.html">Add Customer</a></td>
			<td><a href="/showProducts.html">List Products</a></td>
			<td><a href="/showOrders.html">List Orders</a></td>
			<td><a href="<c:url value='/logout'/>">Logout</a></td>

		</tr>
	</table>
</body>
</html>