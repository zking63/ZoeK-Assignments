<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>person</title>
</head>
<body>
	<h1>${person.firstName} ${person.lastName}</h1>
	<p><strong>License Number:</strong> ${ person.license.getNumberAsString() }</p>
	<p><strong>Expiration Date:</strong> ${ person.license.getExpirationdateformatted() }</p>
	<p><strong>State:</strong> ${ person.license.state }</p>
	<button><a href="/persons">Back to list</a></button>
</body>
</html>