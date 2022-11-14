$(document).ready(function() {
	console.log("form loaded");
	$('#btn-delete').click(function() {
		var noteId=$('.noteId').val();
		console.log(noteId);
	});
});