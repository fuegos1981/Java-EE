<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<title>Поиск задач</title>
</head>
<body>
	<form id = "formFind">
		<table>
		<tr>
			<td>Наименование содержит:</td>
			<td><input type="text" class = "regBtn" name="taskName" /></td>
		</tr>
		<tr>
			<td>Автор задачи:</td>
			<td><input type="text" class = "regBtn" name="Autor" /></td>
		</tr>
		<tr>
			<td>Исполнитель задачи:</td>
			<td><input type="text" class = "regBtn" id="pas" name="Perfomer" /></td>
		</tr>
		</table>
		<input type="submit" id ="find" name="find" value="Найти" />
		<table id = "tabTask">
			<tr>
			</tr>
		</table>	
	</form>
	<script src ="/resources/script.js"></script>
</body>
</html>