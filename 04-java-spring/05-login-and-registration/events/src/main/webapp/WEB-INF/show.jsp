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
	        </tr>
	    </thead>
		<tbody>
			<tr>
				<td>${ event.eventState }</td>
				<td>${ event.getEventDateFormatted() }</td>
				<td>${ event.planner.getFirstName() }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>