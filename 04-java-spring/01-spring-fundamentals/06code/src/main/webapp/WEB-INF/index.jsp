<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
	<span><c:out value="${ error }" /></span>
	<form method="POST" action="/attempt">
		<label>Code: <input type="text" name="code"></label>
		<button>Submit</button>
	</form>
</body>
</html>