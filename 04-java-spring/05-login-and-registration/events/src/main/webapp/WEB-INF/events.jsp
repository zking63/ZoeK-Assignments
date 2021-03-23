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
	<h1>Hello, ${ user.firstName }</h1>
	<div class="events">
	<h1>Events</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>State</th>
	            <th>Date</th>
	            <th>Host</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ usersStates }" var="e">
				<tr>
					<td>${ e.name }</td>
					<td>${ e.eventState }</td>
					<td>${ e.getEventDateFormatted() }</td>
					<td>${ e.planner.getFirstName() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>State</th>
	            <th>Date</th>
	            <th>Host</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ otherStates }" var="s">
				<tr>
					<td>${ s.name }</td>
					<td>${ s.eventState }</td>
					<td>${ s.getEventDateFormatted() }</td>
					<td>${ s.planner.getFirstName() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="new event">
		<h1>Create an event</h1>
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