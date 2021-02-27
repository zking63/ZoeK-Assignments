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
	<form method="POST" action="/result">
		<label>Name<input type="text" name="name"></label>
		<label>Location<input type="text" name="location"></label>
		<label>Favorite Language</label>
			<select name="language" id="location">
			  <option value="java">Java</option>
			  <option value="python">Python</option>
			  <option value="C">C</option>
			  <option value="javascript">Javascript</option>
			</select>
		<button>Submit</button>
	</form>
</body>
</html>