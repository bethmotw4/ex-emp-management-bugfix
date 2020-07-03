/**
 * 
 */
"use strict";
$(function() {
	
	
	
	$("#imageinput").change(function() {
		if (this.files.length > 0) {
			var file = this.files[0];
		}
		var reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = function() {
			$("#image").val(reader.result);
		};
	});
});