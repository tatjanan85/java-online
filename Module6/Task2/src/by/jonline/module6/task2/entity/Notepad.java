package by.jonline.module6.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Notepad {
	private List<Note> notes;

	public Notepad() {
		notes = new ArrayList<Note>();
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Note> getNotes() {
		return notes;
	}
}
