package by.jonline.module6.task1.view;

import by.jonline.module6.task1.entity.Book;
import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.exception.AutorizationException;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;
import by.jonline.module6.task1.service.LibraryService;
import by.jonline.module6.task1.service.MailService;
import by.jonline.module6.task1.service.ServiceProvider;
import by.jonline.module6.task1.service.UserService;
import by.jonline.module6.task1.view.impl.PageReviewMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

	private static View instance;
	private UserService userService;
	private LibraryService libraryService;
	private MailService mailService;
	private final Scanner reader;

	private View() {

		reader = new Scanner(System.in);

		try {
			userService = ServiceProvider.getInstance().getUserService();
			libraryService = ServiceProvider.getInstance().getLibraryService();
			mailService = ServiceProvider.getInstance().getMailService();
		} catch (FileNotFoundException e) {
			printError(e.getMessage());
		} catch (IOException e) {
			printError("Ошибка ввода-вывода");
		}
	}

	public static View getInstance() {
		if (instance == null) {
			instance = new View();
		}
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

	public MailService getMailService() {
		return mailService;
	}

	public Scanner getReader() {
		return reader;
	}

	public int getUserChoice(int lastItem) {
		int choice;
		boolean firstCycle = true;

		do {
			if (!firstCycle) {
				System.out.println("неверно выбрано действие");
			}

			while (!reader.hasNextInt()) {
				System.out.println("неверно выбрано действие");
				reader.next();
			}

			choice = reader.nextInt();
			firstCycle = false;
		} while (choice < 1 || choice > lastItem);

		return choice;
	}



	public void printBooks(List<Book> books) {
		System.out.println("---------------------------------");
		System.out.println("Результаты поиска:");

		if (books.size() > 0) {
			books.forEach(System.out::println);
		} else {
			System.out.println("данные не найдены");
		}

		System.out.println("---------------------------------");
	}

	public void printError(String message) {
		System.out.println(message);
	}

}
