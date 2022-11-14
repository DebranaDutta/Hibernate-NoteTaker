$(document).ready(function() {
	$('#button2').click(function() {
		var noteTitle = $('#noteTitle').val();
		var noteContent = $('#noteContent').val();
		$.ajax({
			type : 'POST',
			url : 'AddNoteController',
			data : {
				noteTitle : noteTitle,
				noteContent : noteContent
			},
			success : function(resp) {
				console.log(resp);
				swal("Note added successfully. Redirecting to Show Notes page")
				.then((value)=>{
					window.location="showNotes.jsp"
				});
			}
		});
	});
});