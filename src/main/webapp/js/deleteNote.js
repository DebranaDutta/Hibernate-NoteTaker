//Incase of we are working with multiple input tags inside for loop
//<input type="hidden" class="noteId" value="<%=note.getId()%>" />
/*const noteId=document.querySelectorAll(".noteId");
console.log(noteId);
for(let i=0;i<noteId.length;i++){
	console.log(noteId[i].value);
}*/

$(document).on('click','.btnDelete',function(event){
	console.log('bal');
	var noteId=$(event.target).val();
	$.ajax({
		type:'POST',
		url:'deleteNoteController',
		data:{
			noteId:noteId
		},
		success:function(data){
			if(data.trim()==='success'){
				swal("Note deleted successfully. Redirecting to Show Notes page")
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