<%@page import="com.test.beans.CreateAccount"%>
<%@page import="java.util.List"%>
<%@page import="com.test.service.Balance"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.aa {
	margin-left: 80%;
	padding-right: 10%;
}
</style>
</head>

<body>
	<div class="ss">
		<h1>Welcome to NetBanking</h1>
	</div>
	<hr>
	<h4>User Name -: ${email }</h4>
	<div class="aa">
		<a href="main.jsp">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; <a
			href="login.jsp">Logout</a>
	</div>
	<hr>
	<%! List<CreateAccount> createAccount;
	%>
	<%	createAccount = new Balance().accountDetails(email);
	%>
	<br>
	<div class="acc">
	<% for(CreateAccount acc: createAccount)
	{ %> First Name -: <%= acc.getFirstName() %>
	 <%= acc.getLastName() %><br><br>
	<!-- Date of Birth -: <%= acc.getDate() %><br><br> --> 
	 Account Number -: <%=acc.getAccountNumber() %><br><br>
	 Email Id -: <%= acc.getEmail() %><br><br>
	 Phone Number -: <%= acc.getPhoneNumber() %><br><br>
	 Account Balance -: <%=acc.getAccountBalance() %><br><br>
	 
	<%} %>
	</div>
</body>
</html>