<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/" method="get">
	<input type="submit" name="AddNewRow" value ="Add row" />
</form>
<table border="1">
        <caption>Users</caption>
        <thead>
          <tr>
            <th>id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>email</th>            
            <th>age</th>
            <th>role</th>
            <th>operations</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${list}">
			<tr class ="AddRow">
	            <td>${user.id}</td>
	            <td><input  type="text"  name="firstName" value="${user.firstName}" id ="firstName${user.id}"/></td>
	            <td><input  type="text"  name="lastName" value="${user.lastName}"  id ="lastName${user.id}"/></td>
	            <td><input  type="email"  name="email" value="${user.email}" id ="email${user.id}"/></td>
	            <td><input  type="number"  name="age" value="${user.age}" id ="age${user.id}"/></td>
	            <td><input  type="text"  name="role" value="${user.role}" id ="role${user.id}"/></td>
	            <td>
		            <input type="button" class="user-update-submitter" name="Update${user.id}" value ="Update" data-id="${user.id}" />
		            <a href="DeleteUser?id=${user.id}">delete</a>
	            </td>
	          </tr>
		</c:forEach>
    </tbody>
</table>
        <form id="update-user" action="/UpdateUser" method="post">
        	<input type="hidden" name="id" value="1" id = "itId"/>
           	<input type="hidden" name="firstName" value="1" id = "itfName"/>
			<input type="hidden" name="lastName" value="1" id ="itlName"/>
			<input type="hidden" name="email" value="1" id = "itEmail"/>
			<input type="hidden" name="age" value="1" id = "itAge"/>
			<input type="hidden" name="role" value="1" id = "itRole"/>
        </form> 
        
        <script>
			try{
				// Константы имен классов и id
				var className = "user-update-submitter";
				var formId = "update-user";
				
				(function(){
					// Получаем ссылки на узлы DOM
					var submitters = document.getElementsByClassName(className); // массив ссылок на все кнопки Update
					var updateUserForm = document.getElementById(formId); // ссылка на форму сабмита изменений
					
					// Заполнит поля формы измнения пользователя
					var setRowValuesToHiddenFields = function(userId){
						
						var textEditfName = document.getElementById("itfName");
	            		var newValueFName = document.getElementById("firstName"+userId).value;
	            		
	            		textEditfName.setAttribute("value",newValueFName);
	            		document.getElementById("itfName").setAttribute("value",document.getElementById("firstName"+userId).value);
	            		document.getElementById("itId").setAttribute("value", userId);
	            		document.getElementById("itlName").setAttribute("value", document.getElementById("lastName"+userId).value);
	            		document.getElementById("itEmail").setAttribute("value", document.getElementById("email"+userId).value);
	            		document.getElementById("itAge").setAttribute("value", document.getElementById("age"+userId).value);
	            		document.getElementById("itRole").setAttribute("value", document.getElementById("role"+userId).value);
					};
					
					
					var buttonEl = null;
					// Перебор всех кнопок и назначение обработчика события 
					// нажатия на каждую из них
					for (index = 0; index < submitters.length; ++index) {
						
						buttonEl = submitters[index];
						
						buttonEl.onclick = function(){
							setRowValuesToHiddenFields(this.dataset.id);
							
							//console.info(this.dataset);
							updateUserForm.submit();
						};
						
						
					};
					buttonEl = null;
				})();
				
			} catch( e ){
				alert(e.message);
				console.warn(e);
			}
		</script>
</body>
</html>