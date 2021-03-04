<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New languages</title>
</head>
<body>
	<h1>Details for Language #${ language.id }</h1>
	<h1><c:out value="${language.name}"/></h1>
	<p>Creator: <c:out value="${language.creator}"/></p>
	<p>Current Version: <c:out value="${language.currentVersion}"/></p>
	<a class="btn btn-primary" href="/${language.id}/edit">Edit Language</a>
</body>
</html>