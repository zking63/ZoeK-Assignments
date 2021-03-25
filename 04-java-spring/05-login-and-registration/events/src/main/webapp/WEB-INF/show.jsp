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
	<button><a href="/logout">Logout</a></button>
	<button><a href="/home">Home</a></button>
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
	<div class="comments">
		<h2>Comments</h2>
		<p><c:forEach items="${ event.eventComments }" var="c">
			<p>${ c.commenter.getFirstName() }: ${ c.comment }</p>
		</c:forEach></p>
	</div>
	<div class="newcomment">
		<form method="POST" action="/${event.id}/comment">
	    	<label for="comment">Add Comment</label>
			<textarea name="comment" id="comment" class="form-control"></textarea>
			<button>Submit</button>
	    </form>
	</div> 
</body>
</html>