package by.jonline.module6.task2.view.menuImpl;

import by.jonline.module6.task2.entity.Notepad;
import by.jonline.module6.task2.exception.InvalidNoteFileFormatException;
import by.jonline.module6.task2.service.NotepadService;
import by.jonline.module6.task2.service.ServiceProvider;
import by.jonline.module6.task2.view.Menu;
import by.jonline.module6.task2.view.View;
import by.jonline.module6.task2.view.actionImpl.AddNoteActionView;
import by.jonline.module6.task2.view.actionImpl.DeleteNoteActionView;
import by.jonline.module6.task2.view.actionImpl.LogoutActionView;

import java.io.IOException;

public class MainMenu implements Menu {

	private static Menu instance;
	private View view = View.getInstance();
	private NotepadService notepadService = ServiceProvider.getInstance().getNotepadService();

	private MainMenu() {
		try {
			notepadService.setNotepad(new Notepad());
			notepadService.loadUserNotes();
		} catch (InvalidNoteFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new MainMenu();

		}
		return instance;
	}

	@Override
	public void show() {

		System.out.println("Выберите действие:");
		System.out.println("1 - мои заметки");
		System.out.println("2 - поиск");
		System.out.println("3 - добавить заметку");
		System.out.println("4 - удалить заметку");
		System.out.println("5 - выйти из программы");

		int lastItem = 5;

		int choice = view.getUserChoice(lastItem);
		chooseActionView(choice);

	}

	@Override
	public void chooseActionView(int choice) {
		switch (choice) {
			case 1:
				SortMenu.getInstance().show();
				break;
			case 2:
				SearchMenu.getInstance().show();
				break;
			case 3:
				AddNoteActionView.getInstance().show();
				break;
			case 4:
				DeleteNoteActionView.getInstance().show();
				break;
			case 5:
				LogoutActionView.getInstance().show();
				break;
		}

	}
}
