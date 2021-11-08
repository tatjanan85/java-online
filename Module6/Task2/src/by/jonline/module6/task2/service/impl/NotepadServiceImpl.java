package by.jonline.module6.task2.service.impl;

import by.jonline.module6.task2.dao.DAOProvider;
import by.jonline.module6.task2.dao.NoteDAO;
import by.jonline.module6.task2.entity.Note;
import by.jonline.module6.task2.entity.Notepad;
import by.jonline.module6.task2.exception.InvalidDataInputException;
import by.jonline.module6.task2.exception.InvalidFileNoteIdFormatException;
import by.jonline.module6.task2.exception.InvalidNoteFileFormatException;
import by.jonline.module6.task2.service.NotepadService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NotepadServiceImpl implements NotepadService {

	private NoteDAO noteDAO;
	private Notepad notepad;

	public NotepadServiceImpl() {
		noteDAO = DAOProvider.getInstance().getNoteDAO();
	}

	@Override
	public Notepad getNotepad() {
		return notepad;
	}

	@Override
	public void setNotepad(Notepad notepad) throws InvalidNoteFileFormatException, IOException {
		this.notepad = notepad;
		loadUserNotes();
	}

	@Override
	public void addNote(String theme, String message, String email) throws InvalidFileNoteIdFormatException, IOException, InvalidDataInputException {
		List<Note> notes = notepad.getNotes();

		if (emailValidation(email)) {

			int id = noteDAO.getLastUsedId();

			Note note = new Note(theme, message, email);
			note.setId(id);

			notes.add(note);
			notepad.setNotes(notes);

			noteDAO.setLastUsedId(id + 1);
		} else {
			throw new InvalidDataInputException("Неверно введены данные. Ошибка email");
		}
	}

	@Override
	public boolean deleteNote(int id) {
		List<Note> notes = notepad.getNotes();
		List<Note> toBeDeleted = notes.stream()
				.filter(e -> e.getId() == id)
				.collect(Collectors.toList());

		if (toBeDeleted.size() == 0) {
			return false;
		}

		notes.remove(toBeDeleted.get(0));
		notepad.setNotes(notes);
		System.out.println(notepad.getNotes());

		return true;
	}

	@Override
	public List<Note> findNoteById(String id) throws InvalidDataInputException {
		List<Note> result = new ArrayList<Note>();
		Pattern validationPattern = Pattern.compile("[1-9]{1}[0-9]*");
		Matcher idValidationMatcher = validationPattern.matcher(id);
		if (!idValidationMatcher.matches()) {
			throw new InvalidDataInputException("Неверный формат id");
		}

		Pattern searchPattern = Pattern.compile(id);
		Matcher searchMatcher;

		for (Note note : notepad.getNotes()) {
			searchMatcher = searchPattern.matcher(String.valueOf(note.getId()));

			if (searchMatcher.matches()) {
				result.add(note);
				break;
			}
		}

		return result;
	}

	@Override
	public List<Note> findByMultipleParameters(String keyword, String date, String email)
			throws InvalidDataInputException {
		List<Note> result1 = new ArrayList<Note>();
		List<Note> result2 = new ArrayList<Note>();
		List<Note> result3 = new ArrayList<Note>();

		if (keyword.length() > 0) {
			result1 = findNoteByKeyword(keyword);
		} else {
			result1 = notepad.getNotes();
		}

		if (date.length() > 0) {
			result2 = findNoteByCreationDate(date);
			result2.retainAll(result1);
		} else {
			result2 = result1;
		}

		if (email.length() > 0) {
			result3= findNoteByMail(email);
			result3.retainAll(result2);
		} else {
			result3 = result2;
		}

		return result3;
	}

	@Override
	public List<Note> findNoteByKeyword(String keyword)  {
		List<Note> result = new ArrayList<Note>();
		keyword = keyword.toLowerCase();

		Pattern pattern = Pattern.compile(keyword);
		Matcher matcher1, matcher2;

		for (Note note : notepad.getNotes()) {
			matcher1 = pattern.matcher(note.getMessage().toLowerCase());
			matcher2 = pattern.matcher(note.getTheme().toLowerCase());

			if (matcher1.find() || matcher2.find()) {
				result.add(note);
			}
		}

		return result;
	}

	@Override
	public List<Note> findNoteByMail(String email) throws InvalidDataInputException {
		List<Note> result = new ArrayList<Note>();
		email = email.toLowerCase();

		if (emailValidation(email)) {
			Pattern pattern = Pattern.compile(email);

			for (Note note : notepad.getNotes()) {
				Matcher matcher = pattern.matcher(note.getEmail());
				if (matcher.matches()) {
					result.add(note);
				}
			}
		} else {
			throw new InvalidDataInputException("Неверно введены данные. Ошибка email");
		}

		return result;
	}

	@Override
	public List<Note> findNoteByCreationDate(String date) throws InvalidDataInputException {
		List<Note> result = new ArrayList<Note>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		Pattern pattern = Pattern.compile("([0-3]{1}[0-9]{1}).([0-1]{1}[0-9]{1}).(19|20[0-9]{2})");
		Matcher matcher = pattern.matcher(date);
		boolean check = matcher.matches();

		if (check) {

			int day = Integer.parseInt(matcher.group(1));
			int month = Integer.parseInt(matcher.group(2));
			int year = Integer.parseInt(matcher.group(3));

			if (month > 12) {
				throw new InvalidDataInputException("Неверная дата. Такого месяца не существует");
			}

			switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (day > 31) {
						throw new InvalidDataInputException("Неверная дата. Нет столько дней в данном месяце");
					}
				case 4:
				case 6:
				case 9:
				case 11:
					if (day > 30) {
						throw new InvalidDataInputException("Неверная дата. Нет столько дней в данном месяце");
					}
				case 2:

					if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
						if (day > 29) {
							throw new InvalidDataInputException("Неверная дата. Нет столько дней в данном месяце");
						}
					} else {
						if (day > 28) {
							throw new InvalidDataInputException("Неверная дата. Нет столько дней в данном месяце");
						}
					}
				default:
					break;
			}

			LocalDate lDate = LocalDate.parse(date, formatter);

			for (Note note : notepad.getNotes()) {
				if (note.getCreationDate().equals(lDate)) {
					result.add(note);
				}
			}
		} else {
			throw new InvalidDataInputException("Неверно введены данные. Ошибка ввода даты");
		}

		return result;
	}

	@Override
	public void loadUserNotes() throws IOException, InvalidNoteFileFormatException {
		noteDAO.loadUserNotes(notepad);
	}

	@Override
	public void saveUserNotes() throws IOException, InvalidNoteFileFormatException {
		sortNotesById();
		noteDAO.saveUserNotes(notepad);
	}

	@Override
	public void sortNotesById() {
		List<Note> result = notepad.getNotes().stream()
				.sorted(Comparator.comparing(Note::getId))
				.collect(Collectors.toList());
		notepad.setNotes(result);
	}

	@Override
	public void sortNotesByTheme() {
		List<Note> result = notepad.getNotes().stream()
				.sorted(Comparator.comparing(Note::getTheme))
				.collect(Collectors.toList());
		notepad.setNotes(result);
	}

	@Override
	public void sortNotesByCreationDate() {
		List<Note> result = notepad.getNotes().stream()
				.sorted(Comparator.comparing(Note::getCreationDate))
				.collect(Collectors.toList());
		notepad.setNotes(result);
	}

	private boolean emailValidation(String value) {
		return value.matches("^\\S+@{1}\\S+\\.{1}\\S{2,}$");
	}

}
