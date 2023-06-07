<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
<%@ include file="header.jsp"%>
</head>
<style>
.abc {
	padding: 5%;
	text-align: center;
	background-color: yellowgreen;
}
</style>
<body>
	

	<form action="depositAmount" method="post">
		<div class="abc">

			Enter Amount <input type="text" name="amount"><br>
			<br> <input type="submit" value="Enter">
		</div>
	</form>
</body>
</html>