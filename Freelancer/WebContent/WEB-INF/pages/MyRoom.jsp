<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<title>My Room</title>
</head>
<body>
	<a href ="/">Главная</a>
	<form>
		<button name = "taskClose" id ="taskClose" >Закрытые задачи</button>
		<button name = "endTask" id ="endTask" >Завершенные задачи</button>
		<button name = "taskInDev" id ="taskInDev" >Задачи в разработке</button>
		<button name = "openTask" id ="openTask" >Новые задачи</button>
	</form>
	<sec:authorize access="hasRole('ROLE_AUTOR')">
		<a href ="/addTask">ДобавитьЗадачу</a>
	</sec:authorize>
	<table>
		<tbody  id = "tasksBody">
          <c:forEach var="task" items="${listTask}">
          		<tr class ="AddRow">
          		<td>${task.id}</td>
            	<td>${task.tema}</td>
            	<td>${task.price}</td>
				<td>${task.description}</td>
				<td>${task.autor.getName()}</td>
				<td><button name = "enterCor" data-id ="${task.id}" >Ввести комент</button></td>
				<td><button name = "changeTask${user.id}" class = "changeTask" data-id ="${task.id}" >Редактировать задачу</button></td>
				<td><input  type="hidden"  name="coment" value="" data-id ="${task.id}"/></td>
          		</tr>
          	 </c:forEach>
        </tbody>
	</table>
	<form id="update-task" action="/UpdateTask" method="get">
        	<input type="hidden" name="id" value="1" id = "itId"/>
    </form>   
	<script src ="/resources/script.js"></script>
</body>
</html>