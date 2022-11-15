package com.NoteTaker.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NoteTaker.Entity.Note;
import com.NoteTaker.Helper.crudOperationOnNotes;
@WebServlet(name = "saveEditNoteController", urlPatterns = {"/saveEditNoteController"})
public class saveEditNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public saveEditNoteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String noteTitle=request.getParameter("noteTitle");
		String noteContent=request.getParameter("noteContent");
		String noteId=request.getParameter("noteId");
		
		System.out.println(noteTitle);
		
		boolean status=crudOperationOnNotes.saveEditedNote(noteId, noteTitle, noteContent);
		if(status==true) {
			List<Note> notes=crudOperationOnNotes.getAllNoteDetails();
			session.setAttribute("notes", notes);
			//out.print("success");
			response.sendRedirect("showNotes.jsp");
		}
	}
}
