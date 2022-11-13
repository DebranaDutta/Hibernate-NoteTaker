$(document).ready(function() {
	console.log("form loaded");
	$('#button2').click(function() {
		var noteTitle = $('#noteTitle').val();
		var noteContent = $('#noteContent').val();
		console.log(noteTitle, noteContent);
		$.ajax({
			type : 'POST',
			url : 'AddNoteController',
			data : {
				noteTitle : noteTitle,
				noteContent : noteContent
			},
			success : function(resp) {

			}
		});
	});
});