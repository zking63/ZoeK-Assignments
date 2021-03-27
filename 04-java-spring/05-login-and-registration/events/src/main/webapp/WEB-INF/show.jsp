<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		crossorigin="anonymous">
	<link rel="stylesheet" href="css/main.css" />
    <title>Event page</title>
</head>
<body>
	<div class="container2">
		<div class="titles">
			<h1>Hello, ${ user.firstName }. Welcome to ${ event.name }.</h1>
			<button><a href="/logout">Logout</a></button>
			<button><a href="/home">Home</a></button>
		</div>
		<div class="event-details-side">
			<h2>Event details</h2>
			<table class="table table-hover">
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
						<td>${ event.planner.firstName }</td>
						<td>
						<c:forEach items="${ event.attendees }" var="e">
						${ e.firstName } 
						</c:forEach>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="event-details-side">
			<h2>Comments</h2>
				<div class="messages">
					<p><c:forEach items="${ event.eventComments }" var="c">
						<p>${ c.commenter.firstName }: ${ c.comment }</p>
					</c:forEach></p>
					<form method="POST" action="/${event.id}/comment">
				</div>
				<div class="form-group">
			    	<label for="comment">Add Comment</label>
					<textarea name="comment" id="comment" class="form-control"></textarea>
					<button>Submit</button>
			    </form>
		    </div>
	    </div>
	</div> 
</body>
</html>