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

<title>Create your own pizza page</title>
</head>
<body>

 <form:form  action="/orders/neworder" method="POST" modelAttribute="pizza">
<h4>Please make you own the Pizza</h4>
  
  <div class="container">
<h4>Select your Topping</h4>
  <select name="topping" multiple>
  	<option value="1">select </option>
    <option value="Cheese">Cheese  </option>
    <option value="Chicken">Chicken </option>
    <option value="Mushroom">Mushroom</option>
    <option value="pineapple">Pineapple</option>
     <option value="apple">Apple</option>
      <option value="mozerella cheese">Mozerella cheese</option>
       <option value="peporoni">Pepporoni</option>
        <option value="olive">Olive</option>
    
  </select>
  </div>
  
    <div class="container">
<h4>Select pizza Size</h4>
  <select name="size">
    <option value="small">small</option>
    <option value="Medium">Medium</option>
    <option value="Large">Large</option>
    <option value="X-Large">X-Large</option>
  </select>
  </div>
  <div>
  <button>Checkout</button>
	</div>
</form:form> 

</body>
</html>