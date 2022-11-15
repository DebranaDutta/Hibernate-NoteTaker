package com.NoteTaker.Controller;

import java.io.IOException;
import java.util.List;
import org.hibernate.query.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import com.NoteTaker.Entity.Note;
import com.NoteTaker.Helper.FactoryProvider;
import com.NoteTaker.Helper.crudOperationOnNotes;
import com.NoteTaker.Helper.getAllNoteDetails;

@WebServlet(name = "showNotesController", urlPatterns = {"/showNotesController"})
public class showNotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public showNotesController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Note> notes=crudOperationOnNotes.getAllNoteDetails();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("notes", notes);
		response.sendRedirect("showNotes.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
