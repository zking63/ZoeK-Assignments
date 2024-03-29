<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>Products</title>
</head>
<body>
	<button><a href="/product/new">Add new product</a></button>
	<button><a href="/category/new">Add new category</a></button>
	<h1>Products</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Description</th>
	            <th>Price</th>
	            <th>ID</th>
	            <th>Category</th>
	            <th>Change</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ product }" var="p">
				<tr>
					<td>${ p.name }</td>
					<td>${ p.description }</td>
					<td>${ p.price }</td>
					<td>${ p.id }</td>
					<td><c:forEach items="${p.categories}" var="cat">
						<c:out value="${cat.name}"/>
						</c:forEach>
					</td>
					<td><a href="/product/${p.id}">Add category</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>