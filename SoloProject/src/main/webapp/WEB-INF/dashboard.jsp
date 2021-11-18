<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">

<title>Dashboard</title>

</head>
<body>
<h2> Hi! <c:out value="${user.firstName } ${user.lastName }" ></c:out> WelCome to the Dashboard</h2>
<a href="/orders/neworder">Create your Own Pizza</a> |
<a href="/orders/postcomments">Comments</a>|	
<a href="/logout">logout</a>
<table  class="table table-striped table-dark">

	<thead>
		<tr>
			<td> Id </td>
			<!-- <td>Pizza Name</td> -->
			<td>Topping</td>
			<td>Size</td>
			<td>Amount</td>
			<td>Action</td>
		</tr>
	</thead>


<tbody>

<c:forEach items="${allPizza }" var ="pizza">
<tr>
	
	<td>${pizza.id}</td>
 	<%-- <td>${pizza.orderPizza}</td> --%>
 	<td>${pizza.topping}</td>
 	<td>${pizza.size}</td>
 	 <td>${pizza.price}</td> 
	<td><a href="/orders/delete/${pizza.id}">Delete</a> | <a href="/orders/edit/${pizza.id}">Edit</a></td>
	
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>