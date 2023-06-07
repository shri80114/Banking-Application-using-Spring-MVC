<%@page import="com.test.service.Balance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<style>
.aa {
	margin-left: 80%;
	padding-right: 10%;
}

.ss {
	text-align: center;
}

.a {
	text-align: center;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="ss">
		<h1>Welcome to NetBanking</h1>
	</div>
	<hr>
	<h4>
		User Name -:
		<%=name%>
	</h4>
	<div class="aa">
		<a href="main.jsp">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; <a
			href="login.jsp">Logout</a>
	</div>
	<hr>
	<div class="a">
		<h3>A/C can be credited with Rs ${ amount } Enter your details &
			check now," read the message.</h3>
	</div>
</body>
</html>