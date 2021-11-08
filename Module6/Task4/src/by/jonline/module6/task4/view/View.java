package by.jonline.module6.task4.view;

import by.jonline.module6.task4.entity.Ship;
import by.jonline.module6.task4.entity.Port;
import by.jonline.module6.task4.service.ShipService;

import java.util.List;
import java.util.Scanner;

public class View {

	private static View instance;

	private View() {}

	public static View getInstance() {
		if (instance == null) {
			instance = new View();
		}
		return instance;
	}

	public void getUserChoice() {
		Scanner reader = new Scanner(System.in);

		int number;
		do {
			System.out.println("Введите количество кораблей");

			while (!reader.hasNextInt()) {
				reader.next();
			}

			number = reader.nextInt();
		} while (number < 1);

		Port port = Port.getInstance();

		ShipService shipService = ShipService.getInstance();
		List<Ship> ships = shipService.createRandomShips(number, port);

		printShips(ships);

		shipService.runShips(ships);
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printShips(List<Ship> ships) {
		ships.forEach(System.out::println);
	}
}
