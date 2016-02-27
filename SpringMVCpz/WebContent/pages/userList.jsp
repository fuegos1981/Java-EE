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
<form action="/" method="get">
	<input type="submit" name="AddNewRow" value ="Add row" />
</form>
<table border="1" id = "Users">
        <caption>Users</caption>
        <thead>
          <tr>
            <th>id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>email</th>            
            <th>age</th>
            <th>role</th>
          </tr>
        </thead>
        <tbody  id = "UsersBody">
        <c:forEach var="user" items="${list}">
			<tr class ="AddRow">
	            <td>${user.id}</td>
	            <td><input  type="text"  name="firstName" value="${user.firstName}" id ="firstName${user.id}" ></td>
	            <td><input  type="text"  name="lastName" value="${user.lastName}"  id ="lastName${user.id}"></td>
	            <td><input  type="text"  name="email" value="${user.email}" id ="email${user.id}"></td>
	            <td><input  type="text"  name="age" value="${user.age}" id ="age${user.id}"></td>
	            <td><input  type="text"  name="role" value="${user.role}" id ="role${user.id}"></td>
	            <td>
		            <form action="/UpdateUser" onsubmit="return SendForm()" method="post">
		            	<script language="JavaScript">
		            	function updateForm(obj) {
		            		var textEditfName = document.getElementById("itfName");
		            		var newValueFName = document.getElementById("firstName"+obj.id).value;
		            		textEditfName.setAttribute("value",newValueFName);
		            		document.getElementById("itfName").setAttribute("value",document.getElementById("firstName"+obj.id).value);
		            		document.getElementById("itId").setAttribute("value", obj.id);
		            		document.getElementById("itlName").setAttribute("value", document.getElementById("lastName"+obj.id).value);
		            		document.getElementById("itEmail").setAttribute("value", document.getElementById("email"+obj.id).value);
		            		document.getElementById("itAge").setAttribute("value", document.getElementById("age"+obj.id).value);
		            		document.getElementById("itRole").setAttribute("value", document.getElementById("role"+obj.id).value);
		            		alert(document.getElementById("itId").value+document.getElementById("itfName").value+document.getElementById("firstName"+obj.id).value);
		                }

		            	function SendForm() {
		            		return true;
		            	}
		            </script>
		            
		            	<input type=hidden name="id" value="1" id = "itId">
		            	<input type=hidden name="firstName" value="1" id = "itfName">
						<input type=hidden name="lastName" value="1" id ="itlName" >
						<input type=hidden name="email" value="1" id = "itEmail">
						<input type=hidden name="age" value="1" id = "itAge">
						<input type=hidden name="role" value="1" id = "itRole">
		            	
		            	<input type="submit" name="Update${user.id}" value ="Update" id="${user.id}" onclick="updateForm(this)"> />
		            	
		            </form> 
		            <a href="DeleteUser?id=${user.id}">delete</a>
	            </td>
	          </tr>
		</c:forEach>
        </tbody>
        
        </table>
</body>
</html>