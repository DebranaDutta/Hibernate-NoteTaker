package com.NoteTaker.Helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.NoteTaker.Entity.Note;

public class getAllNoteDetails {
	public static List<Note> notes;
	public static List<Note> getAllNoteDetails(){
		Session session=FactoryProvider.getFactory().openSession();
		Query<Note> query=session.createQuery("from Note");
		notes=query.getResultList();
		return notes;
	}
}
