package by.jonline.module6.task2.view.actionImpl;

import by.jonline.module6.task2.exception.InvalidDataInputException;
import by.jonline.module6.task2.exception.InvalidFileNoteIdFormatException;
import by.jonline.module6.task2.service.NotepadService;
import by.jonline.module6.task2.service.ServiceProvider;
import by.jonline.module6.task2.view.ActionView;
import by.jonline.module6.task2.view.View;
import by.jonline.module6.task2.view.menuImpl.MainMenu;

import java.io.IOException;
import java.util.Scanner;

public class AddNoteActionView implements ActionView {

	private static ActionView instance;
	private View view = View.getInstance();
	private NotepadService notepadService = ServiceProvider.getInstance().getNotepadService();

	private AddNoteActionView() {}

	public static ActionView getInstance() {
		if (instance == null) {
			instance = new AddNoteActionView();
		}
		return instance;
	}
	@Override
	public void show() {
		Scanner reader = view.getReader();

		System.out.println("Введите тему заметки");
		String theme = reader.nextLine();

		System.out.println("Введите содержание заметки");
		String message = reader.nextLine();

		System.out.println("Введите содержание заметки");
		String email = reader.nextLine();

		try {
			notepadService.addNote(theme, message, email);
			System.out.println("Новая заметка добавлена");
		} catch (InvalidFileNoteIdFormatException | InvalidDataInputException e) {
			view.printError(e.getMessage());
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
		}

		MainMenu.getInstance().show();
	}
}
