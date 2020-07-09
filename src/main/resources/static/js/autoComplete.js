/**
 * 
 */
"use strict";
$( function() {	
	$.ajax({
		url: "http://localhost:8080/employee/getAutoComplete",
		dataType: "json",
		type: "GET",
		async: true
	}).done(function(searchResult) {
		$( "#searchEmployeeName" ).autocomplete({
			source: searchResult,
			autoFocus: true,
			delay: 500,
			minLength: 1
		})
	}).fail(function(XMLHttpRequest, textStatus, errorThrown) {
		console.log("XMLHttpRequest:" + XMLHttpRequest.status);		
		console.log("textStatus:" + textStatus);		
		console.log("errorThrown:" + errorThrown.message);		
	});
 });