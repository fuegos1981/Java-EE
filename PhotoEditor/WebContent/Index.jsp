<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="MainServlet" enctype="multipart/form-data" method="post">
		<button type="submit">UPLOAD</button>
		<input type="file" name="photo" accept="image/jpeg,image/png,image/gif" />
	</form>
	
	<c:forEach var="num" items="${list}">
		<img src=${num}>
	</c:forEach>
	
</body>
</html>