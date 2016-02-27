<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/addUser" method="post">
	First name : <input type="text" name="firstName" />
	Last name : <input type="text" name="lastName" />
	email : <input type="email" name="email" />
	Age : <input type="number" name="age" />
	Role : <select name = "role">
				<option>user</option>
  				<option>admin</option>
  				<option>Super admin</option>
			</select>
	<input type="submit" value="Add"> 
</form>

</body>
</html>