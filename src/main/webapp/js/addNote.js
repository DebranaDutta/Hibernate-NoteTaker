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
			success : function(data, textStatus, jqXHR) {
				if(data.trim()==='success'){
				swal("Note added successfully. Redirecting to Show Notes page")
				.then((value)=>{
					window.location="showNotes.jsp"
				});
				}else{
				swal("Something went wrong!")
				}	
			},
			error : function(jqXHR, textStatus, errorThrown){
				swal("Something went wrong. Please try again");
			},
			processData : false,
			contentType : false
		});
	});
});