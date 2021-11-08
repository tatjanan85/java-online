package by.jonline.module6.task2.view;

import by.jonline.module6.task2.entity.Note;

import java.util.List;
import java.util.Scanner;

public final class View {
	private static View instance;
	private Scanner reader;

	private View() {
		reader = new Scanner(System.in);
	}

	public static View getInstance() {
		if (instance == null) {
			instance = new View();
		}
		return instance;
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

		reader.nextLine();

		return choice;
	}

	public void printNotes(List<Note> notes) {
		System.out.println("---------------------------------");
		System.out.println("Результаты поиска:");

		if (notes.size() > 0) {
			notes.forEach(System.out::println);
		} else {
			System.out.println("данные не найдены");
		}

		System.out.println("---------------------------------");
	}

	public void printError(String message) {
		System.out.println(message);
	}

}
