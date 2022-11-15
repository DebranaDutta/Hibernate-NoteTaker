package com.NoteTaker.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import com.NoteTaker.Helper.getAllNoteDetails;

@WebServlet(name = "AddNoteController", urlPatterns = {"/AddNoteController"})
public class AddNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNoteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noteTitle = request.getParameter("noteTitle");
		String noteContent = request.getParameter("noteContent");
		Note note = new Note(new Random().nextInt(10000), noteTitle, noteContent, new Date());
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		boolean status=crudOperationOnNotes.addNotes(note);
		if(status==true) {
			List<Note> notes=crudOperationOnNotes.getAllNoteDetails();
			httpSession.setAttribute("notes", notes);
			out.print("success");
		}
	}
}
