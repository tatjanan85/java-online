package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.entity.Book;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.view.Menu;
import by.jonline.module6.task1.view.View;

import java.io.IOException;
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
		System.out.println("1 - поиск по автору");
		System.out.println("2 - поиск по ключевому слову");
		System.out.println("3 - поиск по издательству");
		System.out.println("4 - поиск по году издания");
		System.out.println("5 - перейти в главное меню");

		int choice = view.getUserChoice(5);
		chooseAction(choice);
	}

	@Override
	public void chooseAction(int choice) {
		Scanner reader = view.getReader();

		switch (choice) {
			case 1:
				System.out.println("Введите автора:");

				String author = reader.next();

				try {
					List<Book> books = view.getLibraryService().findByAuthor(author);
					view.printBooks(books);
				} catch (InvalidFileBookFormatException e) {
					view.printError(e.getMessage());
				} catch (IOException e) {
					view.printError("Ошибка ввода-вывода");
				}

				show();
				break;
			case 2:
				System.out.println("Введите ключевое слово:");
				String keyword = reader.next();

				try {
					List<Book> books = view.getLibraryService().findByKeyword(keyword);
					view.printBooks(books);
				} catch (InvalidFileBookFormatException e) {
					view.printError(e.getMessage());
				} catch (IOException e) {
					view.printError("Ошибка ввода-вывода");
				}

				show();
				break;
			case 3:
				System.out.println("Введите издательство:");
				String publisher = reader.next();

				try {
					List<Book> books = view.getLibraryService().findByPublisher(publisher);
					view.printBooks(books);
				} catch (InvalidFileBookFormatException e) {
					view.printError(e.getMessage());
				} catch (IOException e) {
					view.printError("Ошибка ввода-вывода");
				}

				show();
				break;
			case 4:
				System.out.println("Введите год издания:");

				while (!reader.hasNext()) {
					System.out.println("Неверные данные. Повторите ввод");
					reader.next();
				}
				int year = reader.nextInt();

				try {
					List<Book> books = view.getLibraryService().findByYear(year);
					view.printBooks(books);
				} catch (InvalidFileBookFormatException e) {
					view.printError(e.getMessage());
				} catch (IOException e) {
					view.printError("Ошибка ввода-вывода");
				}

				ModificationMenu.getInstance().show();
				break;
			case 5:
				MainMenu.getInstance().show();
				break;
		}
	}
}
