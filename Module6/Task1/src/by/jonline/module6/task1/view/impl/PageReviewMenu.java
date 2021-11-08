package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.entity.Book;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.view.Menu;
import by.jonline.module6.task1.view.View;

import java.io.IOException;
import java.util.List;

public class PageReviewMenu implements Menu {

	private static Menu instance;
	private View view = View.getInstance();
	private static int pages;
	private static int currentPage;
	private final int BOOK_PER_PAGE = 5;

	private PageReviewMenu() {}

	public static Menu getInstance(int newPages, int newCurrentPage) {
		if (instance == null) {
			instance = new PageReviewMenu();
		}
		pages = newPages;
		currentPage = newCurrentPage;

		return instance;
	}

	@Override
	public void show() {
		List<Book> books;

		try {
			if (pages > 0) {
				System.out.println("Всего страниц = " + pages);
				System.out.println("Страница " + currentPage);

				books = view.getLibraryService().findNextBookBlock(currentPage * BOOK_PER_PAGE - BOOK_PER_PAGE + 1,
						BOOK_PER_PAGE);

				view.printBooks(books);
				System.out.println("1 - предыдущая страница");
				System.out.println("2 - следующая страница");
				System.out.println("3 - перейти в главное меню");

				int choice = view.getUserChoice(3);
				chooseAction(choice);

			} else {
				System.out.println("База данных пуста");
			}
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
			MainMenu.getInstance().show();
		} catch (InvalidFileBookFormatException e) {
			view.printError(e.getMessage());
			MainMenu.getInstance().show();
		}
	}

	@Override
	public void chooseAction(int choice) {

	}
}
