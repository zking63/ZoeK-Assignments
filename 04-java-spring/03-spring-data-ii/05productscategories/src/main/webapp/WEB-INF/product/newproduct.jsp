<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New product</title>
</head>
<body>
	<h1>Add a new product</h1>
	<form:form action="/product" method="POST" modelAttribute="product">
	    <div>
	        <form:label path="name">First Name</form:label>
	        <form:errors path="name"/>
	        <form:input class="form-control" path="name"/>
	    </div>
	   	<div>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:input class="form-control" path="description"/>
	    </div>
	   	<div>
	        <form:label path="price">Price</form:label>
	        <form:errors path="price"/>
	        <form:input class="form-control" path="price"/>
	    </div>
	    <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>