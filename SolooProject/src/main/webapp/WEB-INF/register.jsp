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

<title>Register page</title>

</head>
<body>

<body>
<div class="container" >
<H3>Pizza Order </H3>
<div class="row">
<div class="column">
<h4> Register</h4>
 <form:form action="/register" method="POST" modelAttribute="user">
	<div class="form-group">
		<form:label path="firstName"> First Name</form:label>
		<form:errors path="firstName"></form:errors>
		<form:input type="text" path="firstName"/>
	</div>
	
	<div class="form-group">
		<form:label path="lastName"> Last Name</form:label>
		<form:errors path="lastName"></form:errors>
		<form:input type="text" path="lastName"/>
	</div>
	<div class="form-group">
		<form:label path="email"> email</form:label>
		<form:errors path="email"></form:errors>
		<form:input type="text" path="email"/>
	</div>
	<div class="form-group">
		<form:label path="password"> Password</form:label>
		<form:errors path="password"></form:errors>
		<form:input type="text" path="password"/>
	</div>
	<div class="form-group">
		<form:label path="confirmPassword"> ConfirmPassword</form:label>
		<form:errors path="confirmPassword"></form:errors>
		<form:input type="text" path="confirmPassword"/>
	</div>
	<input class="btn btn-primary" type="submit" value="Submit"/>

</form:form>
</div>
</div>
<div class="column">
	<h3>Login</h3>
	<p>${loginError}</p>
		<form action="/login" method="Post" >
		<label>Email Address</label>
		<input type="email"  name="lemail">
		<label>Password</label>
		<input type="password" name="lpassword">
		<button>Login</button>
		</form>
</div>
<P><a href="/logout"><button> Logout</button></a></P>


</div> 


</body>
</html>