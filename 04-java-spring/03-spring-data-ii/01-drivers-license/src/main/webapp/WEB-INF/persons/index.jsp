<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>All people</title>
</head>
<body>
	<button><a href="/persons/new">Add new person</a></button>
	<button><a href="/license/new">Add new license</a></button>
	<h1>All people</h1>
	<table>
	    <thead>
	        <tr>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th>ID</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ persons }" var="person">
				<tr>
					<td><a href="/persons/${person.id}">${ person.firstName }</a></td>
					<td>${ person.lastName }</td>
					<td>${ person.id }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>