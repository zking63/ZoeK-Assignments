<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>New product</title>
</head>
<body>
	<h1>View a new product</h1>
		<h1>${product.name}</h1>
		<table>
			<thead>
				<tr>
					<th>Description</th>
					<th>Price</th>	
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${ product.description}</td>
					<td>${ product.price}</td>
					<td>${ product.categories}</td>
				</tr>
			</tbody>
		</table>
		<form action="/product/{product.id}" method ="POST">
        <label for="categories">Choose a category:</label>
		<select id="category" name="categories">
		  	<c:forEach items="${ categories }" var="c">
	        	<option value="${ c.id }">${ c.name }</option>
	        </c:forEach>
		</select>
		<input type="submit" value="Submit"/>
		</form>
</body>
</html>