<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<title>Add task</title>
</head>
<body>
	
	<form name="newTask" id = "newTask" action="/addNewTask" method="post">
		<h2>задача</h2>
		<input type="hidden" class = "regBtn" name="id" value = '${task.id}'/>
		<table>
		<tr>
			<td>Тема:</td>
			<td><input type="text" class = "regBtn" name="tema" value = '${task.tema}' /></td>
		</tr>
		<tr>
			<td>Описание:</td>
			<td><input type="text" class = "regBtn" name="description" value = '${task.description}' /></td>
		</tr>
		<tr>
			<td>Цена:</td>
			<td><input type="text" class = "regBtn" name="price" value = '${task.price}' /></td>
		</tr>
		<tr>
			<td>Исполнитель:</td>
			<td><input type="text" class = "regBtn" name="perfomer" value = '${task.perfomer}' /></td>
		</tr>
		<tr>
			<td>Статус:</td>
			<td><select name="status" >
  					<option selected value="OPEN">Открыт</option>
  					<option value="CLOSED">Закрыт</option>
  					<option value="COMPLETED">Завершен</option>
  					<option value="IN_DEVELOPING">В работе</option>
				</select>
			</td>
		</tr>
		
		</table>
		<input type="submit" id ="addTask" name="addTask" value="Добавить задачу" />
	</form>
	
	<script src ="/resources/script.js"></script>
</body>
</html>