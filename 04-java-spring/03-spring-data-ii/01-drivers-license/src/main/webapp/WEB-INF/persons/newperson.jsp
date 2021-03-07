<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New person</title>
</head>
<body>
	<h1>Add new person</h1>
	<form:form action="/persons" method="POST" modelAttribute="person">
	    <div>
	        <form:label path="firstName">First Name</form:label>
	        <form:errors path="firstName"/>
	        <form:input class="form-control" path="firstName"/>
	    </div>
	   	<div>
	        <form:label path="lastName">Last Name</form:label>
	        <form:errors path="lastName"/>
	        <form:input class="form-control" path="lastName"/>
	    </div>
	    <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>