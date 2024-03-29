<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container">
		<h1>What is your question</h1>
		<form:form action="/questions" method="post" modelAttribute="question">
			 <div class="form-group">
		        <form:label path="qname">Question</form:label>
		        <form:errors path="qname"/>
		        <form:textarea class="form-control" path="qname"></form:textarea>
		    </div>
		    <div class="form-group">
		    	<form:label path="tagsInput">Tag</form:label>
		        <form:errors path="tagsInput"/>
		        <form:textarea class="form-control" path="tagsInput"></form:textarea>
		    </div>
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>