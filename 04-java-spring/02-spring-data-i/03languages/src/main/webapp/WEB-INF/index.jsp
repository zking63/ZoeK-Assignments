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
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${ Languages }" var="lang">
	        <tr>
	            <td><c:out value="${lang.name}"/></td>
	            <td><c:out value="${lang.creator}"/></td>
	            <td><c:out value="${lang.currentVersion}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>