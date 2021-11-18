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
<title>Payment Page</title>
</head>
<body>
<h3>You have successfully Paid</h3>
<p><c:out value="${ pizza.price}"></c:out></p>

<form:form action="/orders/checkout/payment/${pizza.id}" method="POST" modelAttribute="payment">
 	<div class="paymentcontainer">
		<form:label path="cardHolderName"> Cardholder Name</form:label>
		<form:errors path="cardHolderName"></form:errors>
		<form:input type="text" path="cardHolderName"/>
	</div> 
	<div class="paymentcontainer">
		<form:label path="cardNumber"> Card Number</form:label>
		<form:errors path="cardNumber"></form:errors>
		<form:input type="Integer" path="cardNumber"/>
	</div> 
	<div class="paymentcontainer">
		<form:label path="cnv"> cnv</form:label>
		<form:errors path="cnv"></form:errors>
		<form:input type="Integer" path="cnv"/>
	</div> 
	<div class ="paymentcontainer">
		<select name="expirationMonth">
			<option value="1">January </option>
			<option value="2">February </option>
			<option value="3">March </option>	
			<option value="4">April </option>
			<option value="5">May </option>
			<option value="6">June </option>
			<option value="7">July </option>
			<option value="8">August </option>
			<option value="9">September </option>
			<option value="10">October </option>
			<option value="11">November </option>
			<option value="12">December </option>
		</select>
	</div>
	<div class ="paymentcontainer">
		<select name="expirationYear">
			<option value="2">2020 </option>
			<option value="3">2021 </option>	
			<option value="4">2022 </option>
			<option value="5">2023 </option>
			<option value="6">2024 </option>
			<option value="7">2025 </option>
			<option value="8">2026 </option>
			<option value="9">2027 </option>
			<option value="10">2028 </option>
			<option value="11">2029 </option>
			<option value="12">2030 </option>
		</select>
	</div>
	
	<div class ="paymentcontainer">
		<select name="cardType">
			<option value="1">VISA </option>
			<option value="2">MasteCard </option>
			<option value="3">March </option>	
			<option value="4">PaYtm </option>
		</select>
	</div>
<%--  <a href="/orders/checkout/payment/${checoutoneorder.id}">Make Payment</a>
 --%>
 <button>MakePayment</button>
 
<a href="/orders/continue">Countinue</a>
</form:form>








 <%-- <p> <c:forEach items="${allPizza }" var ="pizza">
<tr>
	
	<td>${pizza.id}</td>
 	<td>${pizza.orderPizza}</td>
 	<td>${pizza.topping}</td>
 	<td>${pizza.size}</td>
 	 <td>${pizza.price}</td> 

</tr>
</c:forEach>
</p> --%> 

</body>
</html>