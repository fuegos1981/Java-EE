<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My freelancer</title>
<link rel="stylesheet" href="/resources/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
	<form action="/enter/j_spring_security_check" method="post">
		<div id = "regDiv">
		Логин: <input type="text" name="j_username" id ="j_username" />
		Пароль: <input type="password" name="j_password" id="j_password" />
		<button id = "enter">Ввойти</button>
		<a href ="/registration">Регистрация</a>
		</div>
		<sec:authorize access="isAuthenticated()">
            <input type="text" name="selLogin" value = "<sec:authentication property="principal.username" />" readonly="readonly" id="selLogin" />
            <a  href="<c:url value="/myRoom" />">Мой кабинет</a>
        </sec:authorize>
		<a href ="/logout">Выход</a>
	<div class = "myNav">
		<ul class =mainUl>
			<li class="menu1">Задачи
				<ul class ="submenu1">
					<li><a href ="/allTask">Все задачи</a></li>
					<li><a href ="/findTask">Поиск задач</a></li>
					<li><a href ="customersRating">Рейтинг заказчиков</a></li>
				</ul>
			</li>
			<li class="menu2">Исполнители
				<ul class ="submenu2">
					<li><a href ="/allPerfomers">Все исполнители</a></li>
					<li><a href ="/findPerfomers">Поиск исполнителя</a></li>
					<li><a href ="/perfomersRating">Рейтинг Исполнителей</a></li>
				</ul>
			</li>	
		</ul>
	</div>
	
	<h1>Задачи</h1>
	<table>
		<tbody  id = "tasksBody">
          <c:forEach var="task" items="${listTask}">
          		<tr class ="AddRow">
          		<td>${task.id}</td>
            	<td>${task.tema}</td>
            	<td>${task.price}</td>
            	</tr>
            	<tr class ="AddRow">
				<td>${task.description}</td>
				<td>${task.autor.getName()}</td>
				<td><button name = "enterCor" data-id ="${task.id}" >Ввести комент</button></td>
				<td><input  type="hidden"  name="coment" value="" data-id ="${task.id}"/></td>
          		</tr>
          	 </c:forEach>
        </tbody>
	</table>
	<script src ="/resources/script.js"></script>
	</form>
</body>
</html>