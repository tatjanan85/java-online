package by.jonline.module6.task3.view;

import by.jonline.module6.task3.entity.Case;

import java.util.List;
import java.util.Scanner;

public class View {

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

	public void printError(String message) {
		System.out.println(message);
	}

	public void printCases(List<Case> cases) {
		if (cases.size() == 0) {
			System.out.println("Данные не найдены");
			 return;
		}
		cases.forEach(System.out::println);
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


}
