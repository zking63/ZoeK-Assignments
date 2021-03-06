<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New songs</title>
</head>
<body>
	<h1>Create a new song</h1>
		<form:form action="/songs" method="POST" modelAttribute="song">
	    <div class="form-group">
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input class="form-control" path="title"/>
	    </div>
	   	<div class="form-group">
	        <form:label path="artist">Artist</form:label>
	        <form:errors path="artist"/>
	        <form:input class="form-control" path="artist"/>
	    </div>
	   	<div class="form-group">
	        <form:label path="rating">Rating</form:label>
	        <form:errors path="rating"/>
	        <form:input class="form-control" path="rating"/>
	    </div>
	    <input type="submit" value="Submit"/>
		</form:form>
</body>
</html>