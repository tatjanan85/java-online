package by.jonline.module6.task2.dao.impl;

import by.jonline.module6.task2.dao.NoteDAO;
import by.jonline.module6.task2.entity.Note;
import by.jonline.module6.task2.entity.Notepad;
import by.jonline.module6.task2.exception.InvalidFileNoteIdFormatException;
import by.jonline.module6.task2.exception.InvalidNoteFileFormatException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileNoteDAO implements NoteDAO {

	private final String NOTE_FILE_NAME = "resources/notes.txt";
	private final String NOTE_ID_FILE_NAME = "resources/note_id.txt";
	private final String TEMP_NOTE_FILE_NAME = "resources/temp_notes.txt";

	@Override
	public void loadUserNotes(Notepad notepad) throws IOException, InvalidNoteFileFormatException {
		List<Note> notes = new ArrayList<Note>();
		BufferedReader reader = new BufferedReader(new FileReader(NOTE_FILE_NAME));

		String line;
		Note note;
		while((line = reader.readLine()) != null) {
			note = parseNote(line);

			notes.add(note);
		}

		notepad.setNotes(notes);
		reader.close();
	}

	@Override
	public void saveUserNotes(Notepad notepad) throws IOException, InvalidNoteFileFormatException {
		List<Note> notes = new ArrayList<Note>();
		File file1 = new File(NOTE_FILE_NAME);
		File file2 = new File(TEMP_NOTE_FILE_NAME);

		BufferedReader reader = new BufferedReader(new FileReader(file1));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

		String line, newLine;
		boolean firstLine = true;
		Note fileNote;
		int fileId = 0;
		List<Note> curUserNotes = notepad.getNotes();

		while((line = reader.readLine()) != null) {
			fileNote = parseNote(line);
			fileId = fileNote.getId();

			for (Note curNote : curUserNotes) {

				if (curNote.getId() == fileNote.getId()) {
					if (firstLine) {
						firstLine = false;
					} else {
						writer.newLine();
					}

					newLine = convertNoteToStr(curNote);
					writer.write(newLine);
					break;
				}
			}
		}

		for (Note curNote : curUserNotes) {

			if (curNote.getId() > fileId) {
				if (firstLine) {
					firstLine = false;
				} else {
					writer.newLine();
				}

				newLine = convertNoteToStr(curNote);
				writer.write(newLine);
				break;
			}
		}

		reader.close();
		writer.close();

		file1.delete();
		file2.renameTo(file1);
	}

	@Override
	public int getLastUsedId() throws IOException, InvalidFileNoteIdFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(NOTE_ID_FILE_NAME));

		int last_id = 0;
		try {
			last_id = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			throw new InvalidFileNoteIdFormatException(e);
		} finally {
			reader.close();
		}

		return last_id;
	}

	@Override
	public void setLastUsedId(int id) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(NOTE_ID_FILE_NAME, StandardCharsets.UTF_8, false));

		writer.write(String.valueOf(id));

		writer.flush();
		writer.close();
	}

	private Note parseNote(String value) throws InvalidNoteFileFormatException {

		String[] info = value.split("\\|");

		if (info.length != 5) {
			throw new InvalidNoteFileFormatException("Неверное количество полей в базе");
		}

		int id;
		try {
			id = Integer.parseInt(info[0]);
		} catch (NumberFormatException e) {
			throw new InvalidNoteFileFormatException("Неверный формат данных. Неверный формат id");
		}

		String theme = info[1];
		String message = info[2];

		String email;
		if (info[3].matches("\\S+@{1}\\S+\\.{1}\\S{2,}")) {
			email = info[3];
		} else {
			throw new InvalidNoteFileFormatException("Неверный формат данных. Неверный формат e-mail");
		}


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate creationDate = LocalDate.parse(info[4], formatter);

		Note note = new Note(theme, message, email);
		note.setId(id);
		note.setCreationDate(creationDate);

		return note;
	}

	private String convertNoteToStr(Note note) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return  note.getId() + "|" +
				note.getTheme() + "|" +
				note.getMessage() + "|" +
				note.getEmail() + "|" +
				note.getCreationDate().format(formatter);
	}


}
