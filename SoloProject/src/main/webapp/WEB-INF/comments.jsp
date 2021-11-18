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

<title>Review Page</title>
</head>
<body>
<h4>Welcome to review page</h4>
	
 <form:form action="/orders/postcomments" method="POST" modelAttribute="comment">
	 <div class="container">
		<form:label path="content"> Create comments</form:label>
		<form:errors path="content"></form:errors>
		<form:input type="text" path="content"/>
		
		<button>Post Comment</button>
	</div> 
</form:form>
 <c:forEach items="${ allComments}" var ="comment">
	<td>${comment.content}</td><br>
<td>

 <c:choose>
<c:when test="${comment.likers.contains(oneUser)}">
<a href="/orders/unlikes/${comment.id}">UnLikes</a>
You unlikes this 
</c:when>
<c:otherwise>
<a href="/orders/likes/${comment.id}">Likes</a>
You likes this 
</c:otherwise>
</c:choose>
 <%-- <a href="/orders/likes/${comment.id}">Like</a>| <a href="/orders/unlikes/${comment.id}">UnLike</a> --%>
</c:forEach> 
</body>
</html>