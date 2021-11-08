package by.jonline.module5.task4.view;

import by.jonline.module5.task4.entity.Cave;
import by.jonline.module5.task4.entity.Treasure;
import by.jonline.module5.task4.logic.CaveLogic;

import java.util.List;
import java.util.Scanner;

public class View {

	private CaveLogic caveLogic = new CaveLogic();

	public void printTreasures(List<Treasure> treasures) {
		int i = 0;

		if (treasures.size() > 0) {
			for (Treasure treasure : treasures) {
				System.out.println(++i + ". " + treasure);
			}
		} else {
			System.out.println("сокровища не найдены");
		}
	}

	public void printMenu() {
		System.out.println("----------------------------------");
		System.out.println("ДРАКОН И ЕГО СОКРОВИЩА");
		System.out.println("1 - просмотр сокровищ");
		System.out.println("2 - найти самое дорогое сокровище");
		System.out.println("3 - выбрать сокровища на заданную сумму");
		System.out.println("4 - выход из программы");
	}

	public void userChoice(Cave cave) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			do {
				printMenu();

				while (!sc.hasNextInt()) {
					printMenu();
					sc.nextLine();
				}

				choice = sc.nextInt();
			} while (choice < 1 || choice > 4);

			System.out.println("----------------------------------");

			switch (choice) {
				case 1:
					System.out.println("Все сокровища дракона:");
					printTreasures(cave.getTreasures());
					break;
				case 2:
					System.out.println("Самое дорогое сокровище:");
					printTreasures(caveLogic.findMaxTreasure(cave.getTreasures()));
					break;
				case 3:
					int sum;

					do {
						System.out.println("Введите сумму, на которую нужно выбрать сокровища:");

						while (!sc.hasNextInt()) {
							printMenu();
							sc.nextLine();
						}

						sum = sc.nextInt();
					} while (sum < 1);

					printTreasures(caveLogic.findTreasuresBySum(cave.getTreasures(), sum));

					break;
				case 4:
					System.exit(0);
			}
		}
	}

}
