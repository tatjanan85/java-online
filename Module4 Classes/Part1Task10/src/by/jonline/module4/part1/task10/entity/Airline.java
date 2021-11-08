package by.jonline.module4.part1.task10.entity;

import java.time.LocalTime;
import java.util.List;

public class Airline {

	private String destination;
	private int number;
	private String type;
	private LocalTime time;
	private List<Weekday> days;

	public Airline() {
	}

	public Airline(String destination, int number, String type, LocalTime time) {
		this.destination = destination;
		this.number = number;
		this.type = type;
		this.time = time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public List<Weekday> getDays() {
		return days;
	}

	public void setDays(List<Weekday> days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "Рейс {" +
				"пункт назначения='" + destination + '\'' +
				", номер рейса=" + number +
				", тип самолёта='" + type + '\'' +
				", время=" + time +
				", дни недели=" + days +
				'}';
	}
}
