<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>Expense Details</h1>
	<a href="/expenses">Go back</a>
	<h1>${saveTravelDetails.id }</h1>
	<p>Expense Name: ${saveTravelDetails.name}</p>
	<p>Description: ${saveTravelDetails.description}</p>
	<p>Vendor: ${saveTravelDetails.vendor}</p>
	<p>Amount: ${saveTravelDetails.amount}</p>

</body>
</html>