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
	<p>Name:<c:out value="${ name }" /></p>
	<p>Location:<c:out value="${ location }" /></p>
	<p>Language:<c:out value="${ language }" /></p>
</body>
</html>