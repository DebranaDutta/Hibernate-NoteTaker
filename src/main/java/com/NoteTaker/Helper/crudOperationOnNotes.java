package com.NoteTaker.Helper;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.NoteTaker.Entity.Note;

public class crudOperationOnNotes {
	private static List<Note> notes;
	private static Session session;
	private static Transaction transaction;
	
	public static List<Note> getAllNoteDetails(){
		session=FactoryProvider.getFactory().openSession();
		Query<Note> query=session.createQuery("from Note");
		return notes=query.getResultList();
	}
	
	public static boolean addNotes(Note note) {
		session=FactoryProvider.getFactory().openSession();
		transaction=session.beginTransaction();
		session.save(note);
		transaction.commit();
		return true;
	}
	
	public static boolean deleteNotes(String strNoteId) {
		int noteId=Integer.parseInt(strNoteId);
		session=FactoryProvider.getFactory().openSession();
		transaction=session.beginTransaction();
		Note note=(Note)session.get(Note.class, noteId);
		session.remove(note);
		transaction.commit();
		return true;
	}
	
	public static Note editNote(String strNoteId) {
		int noteId=Integer.parseInt(strNoteId);
		session=FactoryProvider.getFactory().openSession();
		transaction=session.beginTransaction();
		Note note=(Note)session.get(Note.class, noteId);
		return note;
	}
	
	public static boolean saveEditedNote(String strNoteId, String noteTitle, String noteContent) {
		int noteId=Integer.parseInt(strNoteId);
		session=FactoryProvider.getFactory().openSession();
		transaction=session.beginTransaction();
		Note note=(Note)session.get(Note.class, noteId);
		note.setTitle(noteTitle);
		note.setContent(noteContent);
		note.setDate(new Date());
		System.out.println(note);
		session.save(note);
		transaction.commit();
		return true;
	}
}
