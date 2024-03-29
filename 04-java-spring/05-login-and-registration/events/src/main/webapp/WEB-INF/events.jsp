<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css"/>
    <title>Event page</title>
</head>
<body>
	<div class="titles">
		<h1>Hello, ${ user.firstName }</h1>
		<button><a href="/logout">Logout</a></button>
	</div>
	<div class="user-form">
		<h2>Events in your state</h2>
		<table class="table table-hover">
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>State</th>
		            <th>Date</th>
		            <th>Host</th>
		            <th>Action/Status</th>
		        </tr>
		    </thead>
			<tbody>
				<c:forEach items="${ usersStates }" var="e">
					<tr>
						<td><a href="/${e.id}">${ e.name }</a></td>
						<td>${ e.eventState }</td>
						<td>${ e.getEventDateFormatted() }</td>
						<td>${ e.planner.getFirstName() }</td>
						<td>
							<c:choose>
								<c:when test="${ e.planner.id == user.id }">
									<a href="/edit/${ e.id }">Edit</a> |
									<a href="/delete/${ e.id }">Delete</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ e.attendees.contains(user) }">
											<span>Joining</span>
											<form action="/${ e.id }/a/cancel" method="post">
												<input type="hidden" value="cancel" />
												<button>Cancel</button>
											</form>	
										</c:when>
										<c:otherwise>
										<a href="/${ e.id }/a/join">Join</a>
											<form action="/${ e.id }/a/join" method="post">
												<input type="hidden" value="join" />
												<button>Join</button>
											</form>							
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<div class="user-form">
			<h2>Events in other states</h2>
			<table class="table table-hover">
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>State</th>
			            <th>Date</th>
			            <th>Host</th>
			            <th>Action/Status</th>
			        </tr>
			    </thead>
				<tbody>
					<c:forEach items="${ otherStates }" var="s">
						<tr>
							<td><a href="/${s.id}">${ s.name }</a></td>
							<td>${ s.eventState }</td>
							<td>${ s.getEventDateFormatted() }</td>
							<td>${ s.planner.getFirstName() }</td>
							<td>
								<c:choose>
									<c:when test="${ s.planner.id == user.id }">
										<a href="/edit/${ s.id }">Edit</a> |
										<a href="/delete/${ s.id }">Delete</a>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${ s.attendees.contains(user) }">
												<span>Joining</span>
												<form action="/${ s.id }/a/cancel" method="post">
													<input type="hidden" value="cancel" />
													<button>Cancel</button>
												</form>	
											</c:when>
											<c:otherwise>
												<form action="/${ s.id }/a/join" method="post">
													<input type="hidden" value="join" />
													<button>Join</button>
												</form>							
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="user-form">
			<h1>Create an event</h1>
		    <form:form method="POST" action="/home" modelAttribute="event">
		    	<form:hidden value="${ user.id }" path="planner"/>
		    	<p>
		            <form:label path="name">Name:</form:label>
		            <form:errors path="name"></form:errors>
		            <form:input type="name" path="name"/>
		        </p>
		        <p>
		            <form:label path="eventState">State:</form:label>
		            <form:errors path="eventState"></form:errors>
		            <form:input type="eventState" path="eventState"/>
		        </p>
		        <p>
		            <form:label path="eventDate">Date:</form:label>
		            <form:errors path="eventDate"></form:errors>
		            <form:input type="eventDate" value="${dateFormat}" path="eventDate"/>
		        </p>
		        <input type="submit" value="Create!"/>
		    </form:form>
		</div>  
</body>
</html>