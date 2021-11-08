package by.jonline.module6.task2.view.actionImpl;

import by.jonline.module6.task2.service.NotepadService;
import by.jonline.module6.task2.service.ServiceProvider;
import by.jonline.module6.task2.view.ActionView;
import by.jonline.module6.task2.view.View;
import by.jonline.module6.task2.view.menuImpl.MainMenu;

import java.util.Scanner;

public class DeleteNoteActionView implements ActionView {

	private static ActionView instance;
	private View view = View.getInstance();
	NotepadService notepadService = ServiceProvider.getInstance().getNotepadService();

	private DeleteNoteActionView() {}

	public static ActionView getInstance() {
		if (instance == null) {
			instance = new DeleteNoteActionView();
		}
		return instance;
	}

	@Override
	public void show() {
		Scanner reader = view.getReader();

		System.out.println("Введите id которую необходимо удалить");
		String id = reader.nextLine();

		if (id.matches("[1-9]+[0-9]*")) {
			boolean result = notepadService.deleteNote(Integer.parseInt(id));

			if (result) {
				System.out.println("Заметка удалена успешно");
			} else {
				System.out.println("Заметка с данным id не найдена");
			}
			MainMenu.getInstance().show();
		} else {
			System.out.println("Неверный ввод данных");
			show();
		}
	}
}
