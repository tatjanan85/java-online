package by.jonline.module4.part1.task10;

import by.jonline.module4.part1.task10.entity.Airline;
import by.jonline.module4.part1.task10.entity.Weekday;
import by.jonline.module4.part1.task10.view.View;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Создать класс by.jonline.module4.part1.task10.entity.Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа by.jonline.module4.part1.task10.entity.Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * by.jonline.module4.part1.task10.entity.Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class Main {

	public static void main(String[] args) {
		Airline a1 = new Airline("Варшава", 747, "Ту-154", LocalTime.of(15, 00));
		List<Weekday> days1 = List.of(Weekday.WEDNESDAY, Weekday.FRIDAY);
		a1.setDays(days1);

		Airline a2 = new Airline("Прага", 747, "Боинг-737", LocalTime.of(18, 10));
		List<Weekday> days2 =  List.of(Weekday.MONDAY, Weekday.FRIDAY, Weekday.SATURDAY);
		a2.setDays(days2);

		Airline a3 = new Airline("Минск", 747, "Боинг-737", LocalTime.of(9, 50));
		List<Weekday> days3 =  List.of(Weekday.SATURDAY);
		a3.setDays(days3);

		Airline a4 = new Airline("Москва", 747, "ИЛ-86 ", LocalTime.of(22, 35));
		List<Weekday> days4 =  List.of(Weekday.MONDAY, Weekday.TUESDAY, Weekday.SATURDAY, Weekday.SUNDAY);
		a4.setDays(days4);

		Airline a5 = new Airline("Варшава", 747, "Ту-154", LocalTime.of(11, 00));
		List<Weekday> days5 =  List.of(Weekday.MONDAY, Weekday.TUESDAY, Weekday.THIRSDAY, Weekday.SATURDAY, Weekday.SUNDAY);
		a5.setDays(days5);

		List<Airline> airlines = new ArrayList<Airline>();
		airlines.add(a1);
		airlines.add(a2);
		airlines.add(a3);
		airlines.add(a4);
		airlines.add(a5);

		View view = new View();
		view.printAirlinesByDestination(airlines, "Варшава");
		view.printAirlinesByWeekday(airlines, Weekday.MONDAY);
		view.printAirlinesAfterTime(airlines, LocalTime.of(18, 00));

	}
}
