<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>All languages</title>
</head>
<body>
	<h1>All Languages</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>ID</th>
	        </tr>
	    </thead>
			<tbody>
			<c:forEach items="${ language }" var="lang">
				<tr>
					<td><a href="/${ lang.id }">${ lang.name }</a></td>
					<td>${ lang.creator }</td>
					<td>${ lang.currentVersion }</td>
					<td><a href="/songs/delete/${song.id}">Delete</a></td>
					<td>
						<a class="btn btn-primary" href="/${ lang.id }/edit">Edit</a>
						<form id="delete-form" action="/${lang.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="btn btn-danger" type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
</body>
</html>