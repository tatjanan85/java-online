package by.jonline.module6.task2.service;

import by.jonline.module6.task2.entity.Note;
import by.jonline.module6.task2.entity.Notepad;
import by.jonline.module6.task2.exception.InvalidDataInputException;
import by.jonline.module6.task2.exception.InvalidFileNoteIdFormatException;
import by.jonline.module6.task2.exception.InvalidNoteFileFormatException;

import java.io.IOException;
import java.util.List;

public interface NotepadService {

	Notepad getNotepad() ;
	void setNotepad(Notepad notepad) throws InvalidNoteFileFormatException, IOException;

	void addNote(String theme, String message, String email) throws InvalidFileNoteIdFormatException, IOException, InvalidDataInputException;
	boolean deleteNote(int id);

	List<Note> findNoteById(String id) throws InvalidDataInputException;
	List<Note> findNoteByKeyword(String keyword);
	List<Note> findNoteByMail(String email) throws InvalidDataInputException;
	List<Note> findNoteByCreationDate(String date) throws InvalidDataInputException;
	List<Note> findByMultipleParameters(String keyword, String date, String email) throws InvalidDataInputException;

	void sortNotesById();
	void sortNotesByTheme();
	void sortNotesByCreationDate();

	void loadUserNotes() throws IOException, InvalidNoteFileFormatException;
	void saveUserNotes() throws IOException, InvalidNoteFileFormatException;


}
