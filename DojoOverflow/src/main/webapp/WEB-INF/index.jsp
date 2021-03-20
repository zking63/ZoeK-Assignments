<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>Questions</title>
</head>
<body>
	<button><a href="/questions/new">Create a new question</a></button>
	<h1>Questions</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Question</th>
	            <th>Tags</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ question }" var="q">
				<tr>
					<td><a href="/questions/${q.id}">${ q.qname }</a></td>
					<td><c:forEach items="${q.tags}" var="tag">
						<p><c:out value="${tag.subject}"/></p>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>