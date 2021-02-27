<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body>
	<span><c:out value="${ error }" /></span>
	<form class="codeF" method="POST" action="/attempt">
		<label class="code">Code: <input type="text" name="code"></label>
		<button class="codeB">Submit</button>
	</form>
</body>
</html>