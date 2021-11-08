package by.jonline.module6.task2.view.menuImpl;

import by.jonline.module6.task2.entity.Note;
import by.jonline.module6.task2.service.NotepadService;
import by.jonline.module6.task2.service.ServiceProvider;
import by.jonline.module6.task2.view.Menu;
import by.jonline.module6.task2.view.View;

import java.util.List;

public class SortMenu implements Menu {

	private static Menu instance;
	private View view = View.getInstance();

	private SortMenu() {}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new SortMenu();
		}
		return instance;
	}


	@Override
	public void show() {
		System.out.println("Сортировать результаты:");
		System.out.println("1 - не сортировать");
		System.out.println("2 - сортировать по дате создания");
		System.out.println("3 - сортировать по теме");

		int lastItem = 3;

		int choice = view.getUserChoice(lastItem);
		chooseActionView(choice);
	}

	@Override
	public void chooseActionView(int choice) {
		NotepadService notepadService = ServiceProvider.getInstance().getNotepadService();
		List<Note> list;

		switch (choice) {
			case 1:
				list = notepadService.getNotepad().getNotes();
				view.printNotes(list);
				break;
			case 2:
				notepadService.sortNotesByCreationDate();
				list = notepadService.getNotepad().getNotes();
				view.printNotes(list);
				break;
			case 3:
				notepadService.sortNotesByTheme();
				list = notepadService.getNotepad().getNotes();
				view.printNotes(list);
				break;

		}

		MainMenu.getInstance().show();
	}
}
