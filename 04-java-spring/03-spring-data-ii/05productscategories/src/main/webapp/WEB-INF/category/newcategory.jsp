<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New category</title>
</head>
<body>
	<h1>Add a new category</h1>
	<form:form action="/category" method="POST" modelAttribute="category">
	    <div>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input class="form-control" path="name"/>
	    </div>
	    <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>