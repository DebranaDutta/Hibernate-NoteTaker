<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.NoteTaker.Entity.Note"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
ArrayList<Note> notes = (ArrayList<Note>) session.getAttribute("notes");
%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>Note Taker</title>
</head>
<body class="container-fluid">
	<div>
		<%@include file="navbar.jsp"%>
	</div>
	<%
	for (Note note : notes) {
	%>
	<div class="container-fluid mt-3">
		<div class="card" style="border-radius: 15px;">
			<div class="card-header text-center" style="border-radius: 15px; background: #EDF7F7"><%=note.getId()%>
				<input type="hidden" class="noteId" value="<%=note.getId()%>" />
			</div>
			<div class="card-body text-center" style="background: #FEFEFE;">
				<h5 class="card-title" style="font-family: cursive; font-size: 25px;"><%=note.getTitle()%></h5>
				<p class="card-text" style="font-family: cursive;"><%=note.getContent()%></p>
				<input type="button" class="btn btn-success" value="EDIT" id="btn-edit" style="border-radius: 15px; font-family: cursive;" />
				<input type="button" class="btn btn-danger" value="DELETE" id="btn-delete" style="border-radius: 15px; font-family: cursive;" />
			</div>
			<div class="card-footer text-center" style="border-radius: 15px; background: #EDF7F7"><%=note.getDate()%></div>
		</div>
	</div>
	<%
	}
	%>
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
	<!-- Custom Script -->
	<script type="text/javascript" src="js/deleteNote.js"></script>

</body>
</html>