package by.jonline.module6.task2.view.menuImpl;

import by.jonline.module6.task2.entity.Note;
import by.jonline.module6.task2.exception.InvalidDataInputException;
import by.jonline.module6.task2.service.NotepadService;
import by.jonline.module6.task2.service.ServiceProvider;
import by.jonline.module6.task2.view.Menu;
import by.jonline.module6.task2.view.View;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class SearchMenu implements Menu {

	private static Menu instance;
	private View view = View.getInstance();

	private SearchMenu() {}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new SearchMenu();
		}
		return instance;
	}

	@Override
	public void show() {
		System.out.println("Выберите действие:");
		System.out.println("1 - поиск по ключевому слову");
		System.out.println("2 - поиск по дате");
		System.out.println("3 - поиск по e-mail");
		System.out.println("4 - поиск по id");
		System.out.println("5 - расширенный поиск");
		System.out.println("6 - выйти в главное меню");

		int lastItem = 6;

		int choice = view.getUserChoice(lastItem);
		chooseActionView(choice);
	}

	@Override
	public void chooseActionView(int choice) {
		List<Note> result;
		String date, email, id, keyword;
		NotepadService notepadService = ServiceProvider.getInstance().getNotepadService();
		Scanner reader = view.getReader();


		try {
			switch (choice) {
				case 1:
					System.out.println("Введите ключевое слово");
					keyword = reader.nextLine();

					result = notepadService.findNoteByKeyword(keyword);

					view.printNotes(result);
					show();
					break;
				case 2:

					System.out.println("Введите дату в формате ДД.ММ.ГГГГ");
					date = reader.nextLine();

					result = notepadService.findNoteByCreationDate(date);

					view.printNotes(result);
					show();
					break;
				case 3:

					System.out.println("Введите e-mail для поиска:");
					email = reader.nextLine();

					result = notepadService.findNoteByMail(email);

					view.printNotes(result);
					show();
					break;
				case 4:

					System.out.println("Введите id заметки:");
					id = reader.nextLine();

					result = notepadService.findNoteById(id);

					view.printNotes(result);
					show();
					break;
				case 5:

					System.out.println("Введите ключевое слово");
					keyword = reader.nextLine();

					System.out.println("Введите дату в формате ДД.ММ.ГГГГ");
					date = reader.nextLine();

					System.out.println("Введите e-mail для поиска:");
					email = reader.nextLine();

					result = notepadService.findByMultipleParameters(keyword, date, email);

					view.printNotes(result);
					show();
					break;

				case 6:
					MainMenu.getInstance().show();
					break;
			}
		} catch (DateTimeParseException e) {
			view.printError("Неверный формат даты");
			show();
		} catch (InvalidDataInputException e) {
			view.printError(e.getMessage());
			show();
		}
	}
}
