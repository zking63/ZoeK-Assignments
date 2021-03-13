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
		<div class="form-group">
	        <form:label path="product">Product</form:label>
	        <form:errors path="product"/>
	        <form:select class="form-control" path="product">
	        <c:forEach items="${ product }" var="p">
	        	<form:option value="${ d.id }">${ d.name }</form:option>
	        </c:forEach>
	        </form:select>
	    </div>
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
	   	<div>
	        <form:label path="age">Age</form:label>
	        <form:errors path="age"/>
	        <form:input class="form-control" path="age"/>
	    </div>
	    <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>