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
	<form:form action="/ninja" method="POST" modelAttribute="ninja">
		<div class="form-group">
	        <form:label path="dojo">Dojos</form:label>
	        <form:errors path="dojo"/>
	        <form:select class="form-control" path="dojo">
	        <c:forEach items="${ dojo }" var="d">
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