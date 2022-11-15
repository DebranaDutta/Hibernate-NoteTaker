<%@page import="com.NoteTaker.Entity.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%Note note=(Note)session.getAttribute("note"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>Edit Note</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
	</div>
	<div class="container-fluid mt-3 div1">
		<form action="saveEditNoteController" method="post">
			<div class="form-group text-center">
				<label><b style="font-size: 25px">Note ID: <%=note.getId()%></b></label>
			</div>
			<div class="form-group">
				<input type="hidden" id="noteId" name="noteId" value="<%=note.getId()%>">
				<input type="text" id="noteTitle" name="noteTitle" required="required" value="<%=note.getTitle()%>">
			</div>
			<div class="form-group">
				<textarea required="required" id="noteContent" name="noteContent" style="width: 100%; height: 200px; border-radius: 15px"><%=note.getContent()%></textarea>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-info mb-2" id="btnEditSave" value="<%=note.getId()%>">Save</button>
			</div>
		</form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/a2eb5bebaa.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<!-- Custom Script -->
	<!-- <script type="text/javascript" src="js/saveEditedNote.js"></script> -->
</body>
</html>