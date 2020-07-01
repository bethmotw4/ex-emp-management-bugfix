/**
 * 
 */
"use strict";
$(function() {
	$("#insert_button").prop("disabled", true);
	
	$("#confirmationPasswaord").on("keyup", function() {
		var hosturl = "http://localhost:8080/confirmationPasswaordCheck";
		var inputPassword = $("#password").val();
		var inputConfirmationPassword = $("#confirmationPasswaord").val();
		$.ajax({
			url: hosturl,
			type: "GET",
			dataType: "json",
			data: {
				password: inputPassword,
				confirmationPassword: inputConfirmationPassword
			},
			async: true;
		}).done(function(data) {
			// コンソールに取得データを表示
			console.log(data);
			console.dir(JSON.stringify(data));
			$("#confirmation_error").html(data.disagreementMessage);
//			checkがtrueならボタンをクリックできるようにしたい
			if (data.check) {
				
			}
		})
	});
});