<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Net Banking Page</title>
<%@ include file="header.jsp"%>
</head>
<style>
.cs {
	text-align: center;
	padding-top: 60px;
	padding-bottom: 60px
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
	<div class="cs">
	</a> <br> <a href="CheckBalance">
			<li>Check Balance</li><br>
		<a href=deposit>
			<li>Deposit Amount</li>
		</a> <br> <a href=WithDrawalServlet>
			<li>Withdrawal Amount</li>
		<!--   </a> <br> <a href=MoneyTransfer>
			<li>Money Transfer</li> -->
		</a> <br> <a href="AccountDetails">
			<li>Accounts Details</li>
		</a> <br> <a href="bankingStatements">
			<li>Bank Statements</li>
		</a> <br>
		<hr>
		----- Sbi-NetBanking ---

	</div>
</body>
</html>