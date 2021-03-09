<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>All dojos and ninjas</title>
</head>
<body>
	<button><a href="/dojo/new">Add new dojo</a></button>
	<button><a href="/ninja/new">Add new ninja</a></button>
	<h1>All dojos and ninjas</h1>
	<table>
	    <thead>
	        <tr>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th>age</th>
	            <th>ID</th>
	            <th>dojo</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ ninja }" var="ninja">
				<tr>
					<td>${ ninja.firstName }</td>
					<td>${ ninja.lastName }</td>
					<td>${ ninja.age }</td>
					<td>${ ninja.id }</td>
					<td>${ ninja.dojo.getName() }</td>
					<td><a href="/ninja/delete/${ninja.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>