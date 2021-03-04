<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New languages</title>
</head>
<body>
	<h1>Create a new langauge</h1>
		<form:form action="/new" method="POST" modelAttribute="language">
	    <div class="form-group">
	        <form:label path="name">Language Name</form:label>
	        <form:errors path="name"/>
	        <form:input class="form-control" path="name"/>
	    </div>
	   	<div class="form-group">
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input class="form-control" path="creator"/>
	    </div>
	   	<div class="form-group">
	        <form:label path="currentVersion">Version</form:label>
	        <form:errors path="currentVersion"/>
	        <form:input class="form-control" path="currentVersion"/>
	    </div>
	    <input type="submit" value="Submit"/>
		</form:form>
</body>
</html>