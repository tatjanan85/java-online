package by.jonline.module4.part1.task10.view;

import by.jonline.module4.part1.task10.entity.Airline;
import by.jonline.module4.part1.task10.entity.Weekday;
import by.jonline.module4.part1.task10.logic.AirlineLogic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class View {
	private AirlineLogic logic = new AirlineLogic();

	private void printAirlines(List<Airline> airlines) {
		if (airlines.size() > 0) {
			for (Airline airline : airlines) {
				System.out.println(airline);
			}
		} else {
			System.out.println("Данные не найдены");
		}
	}
	public void printAirlinesByDestination(List<Airline> airlines, String destination) {
		List<Airline> result = new ArrayList<Airline>();

		result = logic.findAirlinesByDestination(airlines, destination);

		System.out.println("Cписок рейсов для заданного пункта назначения " + destination + ":");
		printAirlines(result);
		System.out.println("------------------------------");
	}

	// список рейсов для заданного дня недели
	public void printAirlinesByWeekday(List<Airline> airlines, Weekday weekday) {
		List<Airline> result = new ArrayList<Airline>();

		result = logic.findAirlinesByWeekday(airlines, weekday);

		System.out.println("Cписок рейсов для заданного дня недели " + weekday + ":");
		printAirlines(result);
		System.out.println("------------------------------");
	}

	// список рейсов для заданного дня недели, время вылета для которых больше заданного
	public void printAirlinesAfterTime(List<Airline> airlines, LocalTime time) {
		List<Airline> result = new ArrayList<Airline>();

		result = logic.findAirlinesAfterTime(airlines, time);

		System.out.println("Cписок рейсов c временем вылета позже " + time + ":");
		printAirlines(result);
		System.out.println("------------------------------");
	}
}
