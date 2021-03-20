<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>Show question</title>
</head>
<body>
		<h1>${question.qname}</h1>
		<table>
			<thead>
				<tr>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<c:forEach items="${question.tags}" var="t">
						<p><c:out value="${t.subject}"/></p>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<c:forEach items="${question.answers}" var="a">
						<p><c:out value="${a.answer}"/></p>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
	<div>
		<form:form action="/answer/new" method="POST" modelAttribute="answers">
		    <div>
		        <form:label path="answer">Name</form:label>
		        <form:errors path="answer"/>
		        <form:input class="form-control" path="answer"/>
		    </div>
		    <form:hidden path="question" value="${ question.id }"/>
		    <input type="submit" value="Submit"/>
	    </form:form>
    </div>
    <button><a href="/">Back to dashboard</a></button>
</body>
</html>