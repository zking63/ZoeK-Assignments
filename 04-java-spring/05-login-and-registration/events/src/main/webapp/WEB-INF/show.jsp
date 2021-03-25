<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event page</title>
</head>
<body>
	<h1>Hello, ${ user.firstName }. Welcome to ${ event.name }.</h1>
	<h2>Event details</h2>
	<table>
	    <thead>
	        <tr>
	            <th>State</th>
	            <th>Date</th>
	            <th>Host</th>
	            <th>Attendees (${ event.attendees.size() })</th>
	        </tr>
	    </thead>
		<tbody>
			<tr>
				<td>${ event.eventState }</td>
				<td>${ event.getEventDateFormatted() }</td>
				<td>${ event.planner.getFirstName() }</td>
				<td>
				<c:forEach items="${ event.attendees }" var="e">
				${ e.firstName } 
				</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
		<div class="newcomment">
		<h1>Comment</h1>
	    <form:form method="POST" action="/home" modelAttribute="event">
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
	        <input type="submit" value="Create!"/>
	    </form:form>
	</div> 
</body>
</html>