package by.jonline.module4.part1.task4;

import java.time.LocalTime;

/**
 * Создайте класс by.jonline.module4.part2.task4.Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа by.jonline.module4.part2.task4.Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 */
public class Main {

	public static void main(String[] args) {

		LocalTime localTime1 = LocalTime.of(23, 00, 00);
		Train train1 = new Train("Гродно", 547, localTime1);

		LocalTime localTime2 = LocalTime.of(13, 50, 00);
		Train train2 = new Train("Минск", 203, localTime2);

		LocalTime localTime3 = LocalTime.of(23, 20, 00);
		Train train3 = new Train("Минск", 625, localTime3);

		LocalTime localTime4 = LocalTime.of(17, 40, 00);
		Train train4 = new Train("Львов", 754, localTime4);

		LocalTime localTime5 = LocalTime.of(06, 25, 00);
		Train train5 = new Train("Минск", 499, localTime5);

		Train[] trains = new Train[5];
		trains[0] = train1;
		trains[1] = train2;
		trains[2] = train3;
		trains[3] = train4;
		trains[4] = train5;

		View view = new View();
		view.printAllTrains(trains);

		TrainsLogic ta = new TrainsLogic();

		System.out.println("Сортировка по номеру поезда:");
		view.printAllTrains(ta.sortByNumber(trains));

		System.out.println("Сортировка по пункту назначения:");
		view.printAllTrains(ta.sortByDestination(trains));

		int number = 547;
		System.out.println("Поиск информации по поезду номер " + number + ":");
		if (ta.findTrainByNumber(trains, number) != null) {
			System.out.println(ta.findTrainByNumber(trains, number));
		} else {
			System.out.println("данных нет");
		}
	}
}
