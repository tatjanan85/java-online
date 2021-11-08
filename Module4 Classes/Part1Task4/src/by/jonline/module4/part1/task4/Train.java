package by.jonline.module4.part1.task4;

import java.time.LocalTime;
import java.util.Objects;

public class Train {

	private String destination;
	private int number;
	private LocalTime departureTime;

	public Train(String destination, int number, LocalTime departureTime) {
		this.destination = destination;
		this.number = number;
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public int getNumber() {
		return number;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Train)) return false;
		Train train = (Train) o;
		return number == train.number && Objects.equals(destination, train.destination) && Objects.equals(departureTime, train.departureTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, number, departureTime);
	}

	@Override
	public String toString() {
		return "Поезд {" +
				"пункт назначения = " + destination +
				", номер = " + number +
				", время отправления = " + departureTime +
				"}";
	}
}
