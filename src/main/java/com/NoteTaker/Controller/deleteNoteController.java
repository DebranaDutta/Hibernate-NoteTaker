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

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.NoteTaker.Entity.Note;
import com.NoteTaker.Helper.FactoryProvider;
import com.NoteTaker.Helper.crudOperationOnNotes;

@WebServlet(name = "deleteNoteController", urlPatterns = {"/deleteNoteController"})
public class deleteNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteNoteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		
		String strNoteId=request.getParameter("noteId");
		boolean status=crudOperationOnNotes.deleteNotes(strNoteId);
		if(status==true) {
			List<Note> notes=crudOperationOnNotes.getAllNoteDetails();
			httpSession.setAttribute("notes", notes);
			out.print("success");
		}
	}
}
