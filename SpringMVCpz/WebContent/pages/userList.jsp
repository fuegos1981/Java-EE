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
<form action="/addUser" method="post">
	<input type="submit" name="AddNewRow" value ="Add row" />
</form>
<form>
<table border="1" id = "Users">
        <caption>Users</caption>
        <thead>
          <tr>
            <th>id</th>
            <th>email</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>age</th>
            <th>role</th>
          </tr>
        </thead>
        <tbody  id = "UsersBody">
        <c:forEach var="user" items="${list}">
			<tr class ="AddRow">
	            <td>user.id</td>
	            <td>user.lastName</td>
	            <td>user.age</td>
	            <td>user.role</td>
	            <td><form action="/UpdateUser"><input type="submit" name="Update" value ="Update" /></form><form action="/DeleteUser"><input type="submit" name="Delete" value ="Delete"  /></form></td>
	          </tr>
		</c:forEach>
        </tbody>
        
        </table>
</form>
</body>
</html>