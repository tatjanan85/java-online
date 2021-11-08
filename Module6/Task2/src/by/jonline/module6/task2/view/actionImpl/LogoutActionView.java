package by.jonline.module6.task2.view.actionImpl;

import by.jonline.module6.task2.exception.InvalidNoteFileFormatException;
import by.jonline.module6.task2.service.NotepadService;
import by.jonline.module6.task2.service.ServiceProvider;
import by.jonline.module6.task2.view.ActionView;
import by.jonline.module6.task2.view.View;

import java.io.IOException;

public class LogoutActionView implements ActionView {

	private static ActionView instance;
	private View view = View.getInstance();
	NotepadService notepadService = ServiceProvider.getInstance().getNotepadService();

	private LogoutActionView() {};

	public static ActionView getInstance(){
		if (instance == null) {
			instance = new LogoutActionView();
		}
		return instance;
	}

	@Override
	public void show() {
		try {
			notepadService.saveUserNotes();
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
		} catch (InvalidNoteFileFormatException e) {
			view.printError(e.getMessage());
		}
		System.out.println("Данные успешно сохранены");
		System.out.println("Выход из программы");
		System.exit(0);
	}
}
