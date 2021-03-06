<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>${song.title}</title>
</head>
<body>
	<p>Artist: <c:out value="${song.artist}"/></p>
	<p>Rating: <c:out value="${song.rating}"/></p>
	<p>Database ID: <c:out value="${song.id}"/></p>
	<p><a href="/songs/delete/${song.id}">Delete</a></p>
</body>
</html>