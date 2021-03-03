<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>All books</title>
</head>
<body>
	<p><c:out value="${book.title}"/></p>
	<p><c:out value="${book.description}"/></p>
	<p><c:out value="${book.language}"/></p>
	<p><c:out value="${book.numberOfPages}"/></p>
</body>
</html>
