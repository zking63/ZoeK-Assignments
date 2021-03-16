<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
	<title>Show product</title>
</head>
<body>
	<h1>View a category</h1>
		<h1>${category.name}</h1>
		<table>
			<thead>
				<tr>
					<th>Products</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:forEach items="${category.products}" var="product">
						<c:out value="${product.name}"/>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
		<form action="/category/${category.id}" method ="POST">
        <label for="products">Assign a product:</label>
		<select id="products" name="products">
		  	<c:forEach items="${ products }" var="p">
	        	<option value="${ p.id }">${ p.name }</option>
	        </c:forEach>
		</select>
		<input type="submit" value="Submit"/>
		</form>
</body>
</html>