<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items show page </title>
</head>
<body>
<h4>Your Order has been placed.</h4>


<h2>Order Id:${checoutoneorder.id}</h2>
<h2>Pizza:${checoutoneorder.topping}</h2>
<p>Size:${checoutoneorder.size }</p>
<p>Amount:${checoutoneorder.price}</p>

<button>Make Payment</button>
<a href="/orders/checkout/payment/${checoutoneorder.id}">Make Payment</a>
 

<%-- <h2>Task:${oneTaskDetail.content}</h2>

<p> Creator:${oneTaskDetail.creator.id}${oneTaskDetail.creator.firstName}</p>
<p> Assignee:${oneTaskDetail.userAssignTo.id}${oneTaskDetail.userAssignTo.firstName}</p>
<p> Priority:${oneTaskDetail.priority}</p> --%>

<%--  <a href="/orders/edit/${checoutoneorder.id}">Edit</a>
 <a href="/orders/details/delete/${checoutoneorder.id}">Delete</a> --%>

<%-- <c:forEach items="${allPizza }" var ="pizza">
<tr>

	<td> ${pizza.id}</td>
 	<td>${pizza.orderPizza}</td>
 	<td>${pizza.topping}</td>
 	<td>${pizza.size}</td>
 	 <td>${pizza.price}</td> 



</tr>

</c:forEach> --%>

</body>
</html>