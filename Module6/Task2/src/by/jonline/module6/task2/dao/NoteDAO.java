package by.jonline.module6.task2.dao;

import by.jonline.module6.task2.entity.Notepad;
import by.jonline.module6.task2.exception.InvalidFileNoteIdFormatException;
import by.jonline.module6.task2.exception.InvalidNoteFileFormatException;

import java.io.IOException;

public interface NoteDAO {

	void loadUserNotes(Notepad notepad) throws IOException, InvalidNoteFileFormatException;
	void saveUserNotes(Notepad notepad) throws IOException, InvalidNoteFileFormatException;
	int getLastUsedId() throws IOException, InvalidFileNoteIdFormatException;
	void setLastUsedId(int id) throws IOException;
}
