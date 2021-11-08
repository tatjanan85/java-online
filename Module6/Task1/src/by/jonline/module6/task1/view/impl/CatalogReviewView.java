package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.view.ActionView;
import by.jonline.module6.task1.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatalogReviewView implements ActionView {

	private static CatalogReviewView instance;
	private View view = View.getInstance();
	private final int BOOK_PER_PAGE = 5;

	private CatalogReviewView() {}

	public static CatalogReviewView getInstance() {
		if (instance == null) {
			instance = new CatalogReviewView();
		}
		return instance;
	}

	@Override
	public void show() {
		try {
			int booksQuantity =  view.getLibraryService().getBooksQuantity();
			int pages = booksQuantity / BOOK_PER_PAGE;

			if (booksQuantity % BOOK_PER_PAGE > 0) {
				pages++;
			}

			PageReviewMenu.getInstance(pages, 1);
		} catch (FileNotFoundException e) {
			view.printError("Не найден файл базы данных");
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
		}
	}
}
