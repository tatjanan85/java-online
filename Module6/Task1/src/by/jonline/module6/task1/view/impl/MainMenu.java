package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.view.Menu;
import by.jonline.module6.task1.view.View;

public class MainMenu implements Menu {

	private static Menu instance;
	private View view = View.getInstance();

	private MainMenu() {}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}

	@Override
	public void show() {
		System.out.println("Выберите действие:");
		System.out.println("1 - выйти из программы");
		System.out.println("2 - просмотр каталога");
		System.out.println("3 - поиск");

		int lastItem = 4;
		if (view.getUserService().getCurrentUser().getRole() == Role.ADMIN) {
			System.out.println("4 - редактирование каталога");
		} else {
			System.out.println("4 - отправить книгу администратору");
		}

		int choice = view.getUserChoice(lastItem);
		chooseAction(choice);
	}

	@Override
	public void chooseAction(int choice) {
		switch (choice) {
			case 2:
				CatalogReviewView.getInstance().show();
				break;
			case 3:
				SearchMenu.getInstance().show();
				break;
			case 4:
				if (view.getUserService().getCurrentUser().getRole() == Role.ADMIN) {
					ModificationMenu.getInstance().show();
				} else {
					SendBookView.getInstance().show();
				}
				break;
			case 1:
				System.exit(0);
				break;
		}
	}


}
