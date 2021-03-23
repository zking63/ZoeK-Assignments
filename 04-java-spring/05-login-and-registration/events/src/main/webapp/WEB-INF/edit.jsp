<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event update page</title>
</head>
<body>
	<h1>Hello, ${ user.firstName }</h1>
	<div class="new event">
		<h1>${event.name}</h1>
	    <form:form method="POST" action="/edit/${id}" modelAttribute="event">
	    	<form:hidden value="${ user.id }" path="planner"/>
	    	<p>
	            <form:label path="name">Name:</form:label>
	            <form:input type="name" path="name"/>
	        </p>
	        <p>
	            <form:label path="eventState">State:</form:label>
	            <form:input type="eventState" path="eventState"/>
	        </p>
	        <p>
	            <form:label path="eventDate">Date:</form:label>
	            <form:input type="eventDate" value="${dateFormat}" path="eventDate"/>
	        </p>
	        <input type="submit" value="Update!"/>
	    </form:form>
	</div>  
</body>
</html>