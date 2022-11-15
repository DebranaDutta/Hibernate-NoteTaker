$(document).on('click', '.btnEdit', function(event){
	var noteId=$(event.target).val();
	$.ajax({
		type:'POST',
		url:'editNoteController',
		data:{
			noteId:noteId
		},
		success:function(data){
			window.location='editNote.jsp';
		}
	});
});