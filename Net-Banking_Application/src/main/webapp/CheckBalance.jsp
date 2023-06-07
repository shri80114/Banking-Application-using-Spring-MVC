<%@page import="com.test.service.Balance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.aa {
	margin-left: 80%;
	padding-right: 10%;
}

.bal {
	text-align: center;
	padding-top: 5%
}
.ss {
	text-align: center;
}
</style>
</head>
<body>
<div class="ss">
		<h1>Welcome to NetBanking</h1>
	</div>
	<hr>
	<h3>User Name -: ${firstName }</h3>
	<h4>
		<div class="aa">
			<a href="main.jsp">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; <a
				href="login.jsp">Logout</a>
		</div>
	</h4>
	<hr>
	<%! double balance; %>
	<%
	 balance = new Balance().checkBalance(email);
	%>

	<div class="bal">
		<h2>
			Your Account Balance is : &nbsp;
			<%= balance %>
		</h2>
	</div>
</body>
</html>