<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Save Travels</h1>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Expenses</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Actions</th>
<!-- 				<th scope="col">Description</th>
 -->

			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${allSaveTravel}">
				<tr>
					<td>
					<a href="/expense/${travel.id}">${travel.name}></a>
					</td>
					<td>${travel.vendor}</td>
					<td>${travel.amount}</td>
					<td><a href="">Edit</a></td>
<%-- 					<td>${travel.description}</td>
 --%>					
					
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div>
		<a href="/expenses/new">Add an expense</a>
	</div>


</body>
</html>



