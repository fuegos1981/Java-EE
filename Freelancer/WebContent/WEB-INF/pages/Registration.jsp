<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<title>Registration</title>
</head>
<body>
	
	<form name="register" id = "register" action="/addUser" method="post">
		<h2>Регистрация</h2>
		<table>
		<tr>
			<td>Наименование:</td>
			<td><input type="text" class = "regBtn" name="personName" /></td>
		</tr>
		<tr>
			<td>Логин:</td>
			<td><input type="text" class = "regBtn" name="login" /></td>
		</tr>
		<tr>
			<td>Пароль:</td>
			<td><input type="password" class = "regBtn" id="pas" name="pas" /></td>
		</tr>
		<tr>
			<td>Повторите пароль:</td>
			<td><input type="password" class = "regBtn" id="pasDop" name="pasDop" /></td>
		</tr>
		<tr>
			<td>email:</td>
			<td><input type="email" class = "regBtn" name="email" /></td>
		</tr>
		<tr>
			<td colspan="2">Тип:<input type="radio" name="type" value="Заказчик"  /> Заказчик
				<input type="radio" name="type" value="Исполнитель"  /> Исполнитель
			</td>
		</tr>
		</table>
		<input type="button" id="regAddSkill" value="add skill" />
		<table id = "Skills">
        	<caption>Skills</caption>
			 <tbody  id = "skillsBody">
			 <c:set var="temp" value="1" />
			 <c:forEach var="skill" items="${listSkill}">
			 	<c:if test="${temp ==1}">
          			<tr class ="AddRow">
          		</c:if>
            	<td>${skill.name}<input type="checkbox" class = "regCheck" name="checkSkill" value = "${skill.name}" /></td>
          		<c:if test="${3 == temp}">
          			<tr class ="AddRow">
          			<c:set var="temp" value="1"/>
          		</tr>
          		</c:if>
          		<c:set var="temp" value="${temp+1}"/>
          	 </c:forEach>
        	</tbody>
		</table>
	
		<input type="button" id ="reg" name="reg" value="Зарегистрироваться" />
	</form>
	<script src ="/resources/script.js"></script>
</body>
</html>