<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>
	<h1>Hello human</h1>
	<form method="POST" action="/process">
		<p>Your Name: <input type="text" name="name"></p>
		<button>Submit</button>
	</form>
</body>
</html>