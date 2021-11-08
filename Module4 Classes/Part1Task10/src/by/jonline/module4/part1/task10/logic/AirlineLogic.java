package by.jonline.module4.part1.task10.logic;

import by.jonline.module4.part1.task10.entity.Airline;
import by.jonline.module4.part1.task10.entity.Weekday;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirlineLogic {

	// список рейсов для заданного пункта назначения;
	public List<Airline> findAirlinesByDestination(List<Airline> airlines, String destination) {
		List<Airline> result = new ArrayList<Airline>();

		for (Airline airline : airlines) {
			String dest = airline.getDestination();
			if (dest.equalsIgnoreCase(destination)) {
				result.add(airline);
			}
		}
		return result;
	}

	// список рейсов для заданного дня недели
	public List<Airline> findAirlinesByWeekday(List<Airline> airlines, Weekday weekday) {
		List<Airline> result = new ArrayList<Airline>();

		for (Airline airline : airlines) {
			List<Weekday> days = airline.getDays();
			if (days.contains(weekday)) {
				result.add(airline);
			}
		}
		return result;
	}

	// список рейсов для заданного дня недели, время вылета для которых больше заданного
	public List<Airline> findAirlinesAfterTime(List<Airline> airlines, LocalTime time) {
		List<Airline> result = new ArrayList<Airline>();

		for (Airline airline : airlines) {
			LocalTime t = airline.getTime();
			if (t.isAfter(time)) {
				result.add(airline);
			}
		}
		return result;
	}

}
