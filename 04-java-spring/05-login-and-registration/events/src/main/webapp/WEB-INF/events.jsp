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
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ events }" var="e">
				<tr>
					<td>${ e.name }</td>
					<td>${ e.eventState }</td>
					<td>${ e.eventDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="new event">
		<h1>Create an event</h1>
	    <form:form method="POST" action="/home" modelAttribute="event">
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
	            <form:input type="eventDate" path="eventDate"/>
	        </p>
	        <input type="submit" value="Create!"/>
	    </form:form>
	</div>  
</body>
</html>