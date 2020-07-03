/**
 * 
 */
"use strict";
$(function() {
	$("#passwordCheck").on("change", function() {
		if ($(this).prop("checked")) {
			$("#password").attr("type", "text");
		} else {
			$("#password").attr("type", "password");			
		}
	});
	$("#passwordCheck2").on("change", function() {
		if ($(this).prop("checked")) {
			$("#confirmationPasswaord").attr("type", "text");
		} else {
			$("#confirmationPasswaord").attr("type", "password");			
		}
	});
});