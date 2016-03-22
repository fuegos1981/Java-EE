$(document)
		.ready(
				function() {
					hideRegistration();
					UpdateTask();

					$("#regAddSkill")
							.click(
									function(e) {
										var answ = prompt("Введите навык!", "");
										$("#Skills")
												.append(
														answ
																+ "<input type='checkbox' class = 'regCheck' name='checkSkill' value = "
																+ answ + " />")

									});

					$("#reg")
							.click(
									function(e) {
										if ($("#pas").val != $("#pasDop").val) {
											alert("пароль не совпадает с подтвержденным паролем!");
										} else {
											$("#register").submit();
										}

									});

					$("#find")
							.click(
									function(e) {
										e.preventDefault();
										var formData = toJSON($('#formFind')
												.serialize());
										console.log(formData);
										$
												.ajax({
													url : "/find/task",
													type : "POST",
													data : JSON
															.stringify(formData),
													dataType : "json",
													contentType : "application/json; charset=UTF-8",
													success : function(data) {
														var i;
														for (i = 0; i < data.length; i++) {
															var tr = "<tr><td>"
																	+ data[i].tema
																	+ "</td><td>"
																	+ data[i].description
																	+ "</td><td>"
																	+ data[i].autor
																	+ "</td><td>"
																	+ data[i].perfomer
																	+ "</td></tr>";
															$('#tabTask')
																	.append(tr);
														}
														console.log("ddd");
													},
													error : function(error) {
														console.log(error);
													}
												});
									});

					$("#taskClose").click(function(e) {
						e.preventDefault();
						var formData = "status=CLOSED";
						console.log(formData);
						selTasks(formData);
					});
					$("#endTask").click(function(e) {
						e.preventDefault();
						var formData = "status=COMPLETED";
						console.log(formData);
						selTasks(formData);
					});
					$("#taskInDev").click(function(e) {
						e.preventDefault();
						var formData = "status=IN_DEVELOPING";
						console.log(formData);
						selTasks(formData);
					});
					$("#openTask").click(function(e) {
						e.preventDefault();
						var formData = "status=OPEN";
						console.log(formData);
						selTasks(formData);
					});

					/*
					 * $("#enter").click(function (e) { e.preventDefault(); var
					 * formData = "j_username="+$("#j_username").val+
					 * "&j_password="+ $("#j_password").val;
					 * console.log(formData); $.ajax({ url:
					 * "/enter/j_spring_security_check", type: "POST", data:
					 * formData, processData:false, dataType: "text", //
					 * contentType: "application/json", success: function (data) {
					 * if (data ==""){ alert("Неверній логин или пароль!"); }
					 * $("#selLogin").val = data; }, error: function (error) {
					 * console.log(error); } }); });
					 */

				});

function toJSON(paramsString) {
	var sendedObject = {}, serialized = paramsString.split('&'), key, value;
	serialized.forEach(function(val) {
		key = val.split('=')[0];
		value = val.split('=')[1];
		sendedObject[key] = value;
	});
	return sendedObject;
}

function hideRegistration() {
	if ($("#selLogin").length > 0) {
		$("#regDiv").hide();
	}

}

function selTasks(formData) {
	$.ajax({
		url : "/taskClose",
		type : "GET",
		data : formData,
		dataType : "json",
		success : function(data) {

			var i;
			var tr = "";
			for (i = 0; i < data.length; i++) {
				if (data[i].tema != null) {
					tr = tr + "<tr><td>" + data[i].tema + "</td><td>"
							+ data[i].description + "</td><td>" + data[i].autorName
							+ "</td><td>" + data[i].perfomerName + "</td></tr>";
					$('#tasksBody').empty();
					$('#tasksBody').append(tr);
				}
			}
			console.log("data");
		},
		error : function(error) {
			console.log(error);
		}
	});

}
function UpdateTask() {
	try {
		// Константы имен классов и id
		var className = "changeTask";
		var formId = "update-task";

		(function() {
			// Получаем ссылки на узлы DOM
			var submitters = document.getElementsByClassName(className); // массив
			// ссылок
			// на
			// все
			// кнопки
			// Update
			var updateTaskForm = document.getElementById(formId); // ссылка на
			// форму
			// сабмита
			// изменений

			var buttonEl = null;
			// Перебор всех кнопок и назначение обработчика события
			// нажатия на каждую из них
			for (index = 0; index < submitters.length; ++index) {

				buttonEl = submitters[index];

				buttonEl.onclick = function() {
					var textEditfName = document.getElementById("itId");
					textEditfName.setAttribute("value", this.dataset.id);
					// console.info(this.dataset);
					updateTaskForm.submit();
				};

			}
			;
			buttonEl = null;
		})();

	} catch (e) {
		alert(e.message);
		console.warn(e);
	}
}
