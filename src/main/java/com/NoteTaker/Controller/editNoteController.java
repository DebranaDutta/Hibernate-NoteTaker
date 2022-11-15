package com.NoteTaker.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NoteTaker.Entity.Note;
import com.NoteTaker.Helper.crudOperationOnNotes;
@WebServlet(name = "editNoteController" , urlPatterns = {"/editNoteController"})
public class editNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public editNoteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String strNoteId=request.getParameter("noteId");
		Note note = crudOperationOnNotes.editNote(strNoteId);
		session.setAttribute("note", note);
	}
}
