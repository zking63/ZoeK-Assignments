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
	<h2>Events in your state</h2>
	<table>
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
								<form action="/delete/${ e.id }" method="post">
									<input type="hidden" value="delete" />
									<button>Delete</button>
								</form>
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
	<div class="events">
	<h2>Events in other states</h2>
	<table>
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
								<form action="/delete/${ s.id }" method="post">
									<input type="hidden" value="delete" />
									<button>Delete</button>
								</form>
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
	<div class="new event">
		<h1>Create an event</h1>
	    <form:form method="POST" action="/{id}/comment" modelAttribute="message">
	    	<form:hidden value="${ user.id }" path="commenter"/>
	    	<form:hidden value="${ event.id }" path="eventComment"/>
	        <p>
	            <form:label path="comment">Write your comment</form:label>
	            <form:input type="text" path="comment"/>
	        </p>
	        <input type="hidden" value="Create!"/>
	    </form:form>
	</div>  
</body>
</html>