<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
label {
	display: block;
	font: 1rem 'Fira Sans', sans-serif;
}

input, label {
	margin: 0.4rem 0;
}

body {
     padding: 5%;
	text-align: center;
	background-color:Pink;
	height:100px;
	width:80%;
	
}
</style>
</head>
<body>
	<h2>Select dates</h2>
	<form action="MiniStatement" method="post">
		<label for="start">Start date   : <input type="date" id="start"
			name="trip-start" value="9999-99-99" min="2018-01-01"
			max="2030-12-31"></label> 
			
			<label for="start">End date  :   <input
			type="date" id="end" name="trip-end" value="9999-99-99"
			min="2018-01-01" max="2030-12-31"></label> <br>
			 <input
			type="submit"> <input type="reset">
	</form>
</body>
</html>