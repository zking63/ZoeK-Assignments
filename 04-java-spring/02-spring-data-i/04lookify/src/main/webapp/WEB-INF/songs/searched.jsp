<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>All songs</title>
</head>
<body>
	<button><a href="/songs/new">Add song</a></button>
	<button><a href="/songs">Back to library</a></button>
	<h1>All songs by <c:out value="${artist}"/></h1>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Rating</th>
	            <th>ID</th>
	        </tr>
	    </thead>
			<tbody>
			<c:forEach items="${ songs }" var="songs">
				<tr>
					<td><a href="/songs/${ songs.id }">${ songs.title }</a></td>
					<td>${ songs.rating }</td>
					<td>${ songs.id }</td>
					<td><a href="/songs/delete/${songs.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
</body>
</html>