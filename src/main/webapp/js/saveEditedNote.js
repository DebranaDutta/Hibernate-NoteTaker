/*$(document).on('click','.btnEditSave', function(event){
	var noteId=$(event.target).val();
	$.ajax({
		type:'POST',
		url:'saveEditNoteController',
		data:{
			noteId:noteId
		}, 
		success: function(data){
			window.location='showNotes.jsp';
		}
	});
});*/

$(document).ready(function() {
	var noteTitle = document.getElementById("noteTitle").value;
	var noteContent = document.getElementById("noteContent").value;
	var noteId = document.getElementById("noteId").value;
	$('#btnEditSave').click(function() {
		console.log(noteTitle);
		$.ajax({
			type : 'POST',
			url : 'saveEditNoteController',
			data : {
				noteTitle : noteTitle,
				noteContent : noteContent,
				noteId : noteId
			},
			success: function(data){
				if(data.trim()==='success'){
					swal("Note edited successfully.")
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
		});
	});
});