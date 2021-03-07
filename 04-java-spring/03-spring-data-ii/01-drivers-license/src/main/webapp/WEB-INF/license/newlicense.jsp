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
	<form:form action="/license" method="POST" modelAttribute="license">
		<div class="form-group">
	        <form:label path="person">Person</form:label>
	        <form:errors path="person"/>
	        <form:select class="form-control" path="person">
	        <c:forEach items="${ persons }" var="p">
	        	<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
	        </c:forEach>
	        </form:select>
	    </div>
	    <div>
	        <form:label path="state">State</form:label>
	        <form:errors path="state"/>
	        <form:input class="form-control" path="state"/>
	    </div>
	   	<div class="form-group">
	        <form:label path="expiration_date">Expiration Date</form:label>
	        <form:errors path="expiration_date"/>
	        <form:input type="date" class="form-control" path="expiration_date"/>
		</div>
	    <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>