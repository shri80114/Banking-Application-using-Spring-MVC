
<%@page import="java.util.stream.Stream"%>
<%@page import="com.test.service.Statements"%>
<%@page import="com.test.beans.TransactionTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<style>
table, th, td {
	border: 0.5px solid black;
}
.qqq{
text-align: center;
}
.aa {
	margin-left: 80%;
	padding-right: 10%;
}

.ss {
	text-align: center;
}
</style>
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
	<%!List<TransactionTable> transTable;%>
	<%
	transTable = new Statements().getMiniStatement(request.getParameter("trip-start"), request.getParameter("trip-end"));
	%>
	<%
	for (TransactionTable acc : transTable) {
		if (acc.getAccNo() == 1) {
	%>
	<div class="qqq">
	<table>
		<tr>
			<th>AccNo</th>
			<th>TransDate</th>
			<th>Type</th>
			<th>Amount</th>
		</tr>
		<tr>
		<td><%=acc.getAccNo()%>
			<td><%=acc.getTransDate()%></td>
			<td><%=acc.getType()%></td>
			
			<td><%=acc.getAmount()%></td>
	</table>
	<%
	}
	}
	%>
	</div>

</body>
</html>