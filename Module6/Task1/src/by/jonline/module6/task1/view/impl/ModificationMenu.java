package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.entity.*;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.exception.InvalidFileBookIdFormatException;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;
import by.jonline.module6.task1.view.Menu;
import by.jonline.module6.task1.view.View;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ModificationMenu implements Menu {

	private static Menu instance;
	private View view = View.getInstance();

	private ModificationMenu() {}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new ModificationMenu();
		}
		return instance;
	}

	@Override
	public void show() {
		System.out.println("Выберите действие:");
		System.out.println("1 - добавить книгу");
		System.out.println("2 - удалить книгу");
		System.out.println("3 - перейти в главное меню");

		int choice = view.getUserChoice(3);
		chooseAction(choice);
	}

	@Override
	public void chooseAction(int choice) {
		switch (choice) {
			case 1:
				if(addBook()) {
					System.out.println("Книга успешно добавлена");
				}
				show();
				break;
			case 2:
				if(deleteBook()) {
					System.out.println("Книга успешно удалена");
				}
				show();
				break;
			case 3:
				MainMenu.getInstance().show();
				break;
		}
	}

	private boolean deleteBook() {
		Scanner reader = view.getReader();

		int id;

		do {
			System.out.println("Введите id книги, которую нужно удалить из базы: ");
			while (!reader.hasNextInt()) {
				System.out.println("Неверный ввод данных");
				reader.next();
			}
			id = reader.nextInt();
		} while(id < 1);

		List<Book> books;
		try {
			books = view.getLibraryService().findById(id);
		} catch (InvalidFileBookFormatException e) {
			view.printError(e.getMessage());
			return false;
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
			return false;
		}

		if (books.size() == 0) {
			view.printError("Книга с таким id не найдена");
			return false;
		} if (books.size() > 1) {
			view.printError("Найдено несколько книг с данным id. База данных повреждена");
			return false;
		}

		try {
			view.getLibraryService().deleteBook(books.get(0).getId());
		} catch (InvalidFileBookFormatException e) {
			view.printError(e.getMessage());
			return false;
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
			return false;
		}

		return true;
	}

	private boolean addBook() {
		Scanner reader = view.getReader();

		System.out.println("Введите ФИО Автора: ");
		reader.nextLine();
		String author = reader.nextLine();

		System.out.println("Введите название книги: ");
		String title = reader.nextLine();

		System.out.println("Введите количество страниц: ");
		int pages;
		boolean firstCicle = true;

		do {
			if (!firstCicle) {
				System.out.println("Неверно введены данные");
			}

			while(!reader.hasNextInt()) {
				System.out.println("Неверно введены данные");
				reader.next();
			}
			pages = reader.nextInt();
			firstCicle = false;

		} while (pages <= 0);


		System.out.println("Введите издательство: ");
		reader.nextLine();
		String publisher = reader.nextLine();


		System.out.println("Введите год издания: ");
		int year;
		firstCicle = true;

		do {
			if (!firstCicle) {
				System.out.println("Неверно введены данные");
			}

			while(!reader.hasNextInt()) {
				System.out.println("Неверно введены данные");
				reader.next();
			}
			year = reader.nextInt();
			firstCicle = false;

		} while (year <= 1900 || year > Calendar.getInstance().get(Calendar.YEAR));


		System.out.println("Формат книги (1 - бумажная, 2 - электронная): ");
		int type;
		firstCicle = true;

		do {
			if (!firstCicle) {
				System.out.println("Неверно введены данные");
			}

			while(!reader.hasNextInt()) {
				System.out.println("Неверно введены данные");
				reader.next();
			}
			type = reader.nextInt();
			firstCicle = false;

		} while (type < 1 || type > 2);


		Book book;
		if (type == 1) {
			System.out.println("Обложка: 1 - твёрдая, 2 - мягкая: ");
			int cover;
			firstCicle = true;

			do {
				if (!firstCicle) {
					System.out.println("Неверно введены данные");
				}

				while(!reader.hasNextInt()) {
					System.out.println("Неверно введены данные");
					reader.next();
				}
				cover = reader.nextInt();
				firstCicle = false;

			} while (type < 1 || type > 2);

			book = new PaperBook(title, author, pages, publisher, year);

			if (cover == 1) {
				((PaperBook)book).setCover(PaperBook.Cover.HARD);
			} else {
				((PaperBook)book).setCover(PaperBook.Cover.SOFT);
			}

		} else {
			System.out.print("Введите формат электронной книги (например: doc, pdf, fb2): ");
			reader.nextLine();
			String format = reader.nextLine();

			book = new EBook(title, author, pages, publisher, year);
			((EBook)book).setFileFormat(format);
		}

		try {
			view.getLibraryService().addBook(book);
			List<User> users = view.getUserService().getUsersByRole(Role.READER);
			String from = view.getUserService().getCurrentUser().getEmail();
			Mail mail = new Mail(from, users, "В домашнюю библиотеку добавлена новая книга");
			mail.setMessage(book.toString());
			view.getMailService().sendMail(mail);
		} catch (InvalidFileBookIdFormatException e) {
			view.printError(e.getMessage());
			return false;
		} catch (FileNotFoundException e) {
			view.printError("Файл базы данных не найден");
			return false;
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
			return false;
		} catch (MessagingException e) {
			view.printError("Ошибка отправки почтового сообщения: " + e.getMessage());
		} catch (InvalidFileUserFormatException e) {
			view.printError(e.getMessage());
			return false;
		}
		return true;
	}

}
