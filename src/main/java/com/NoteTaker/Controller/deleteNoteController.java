package com.NoteTaker.Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		Session session=FactoryProvider.getFactory().openSession();
		Transaction transaction=session.beginTransaction();
		HttpSession httpSession=request.getSession();
		PrintWriter out=response.getWriter();
		
		//int noteId=Integer.parseInt(request.getParameter("noteId"));
		String noteIdStr=request.getParameter("noteId");
		if(noteIdStr!=null) {
			int noteId=Integer.parseInt(noteIdStr);
			Note note=(Note)session.get(Note.class, noteId);
			session.remove(note);
			transaction.commit();
			session.close();
			out.print("success");
		}else{
			out.print("error");
			session.close();
		}
	}
}
