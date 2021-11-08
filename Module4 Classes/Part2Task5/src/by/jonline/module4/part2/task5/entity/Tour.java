package by.jonline.module4.part2.task5.entity;

import by.jonline.module4.part2.task5.entity.tourParameter.Food;
import by.jonline.module4.part2.task5.entity.tourParameter.Place;
import by.jonline.module4.part2.task5.entity.tourParameter.Transport;
import by.jonline.module4.part2.task5.entity.tourParameter.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tour {
	private List<Place> places = new ArrayList<Place>();
	private Type type;
	private Food food;
	private Transport transport;
	private int days;
	private int price;

	public Tour(Type type, Food food, Transport transport, int days, int price) {
		this.type = type;
		this.food = food;
		this.transport = transport;
		this.days = days;
		this.price = price;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public Type getType() {
		return type;
	}

	public Food getFood() {
		return food;
	}

	public Transport getTransport() {
		return transport;
	}

	public int getDays() {
		return days;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tour)) return false;
		Tour tour = (Tour) o;
		return days == tour.days && price == tour.price && Objects.equals(places, tour.places) && type == tour.type && food == tour.food && transport == tour.transport;
	}

	@Override
	public int hashCode() {
		return Objects.hash(places, type, food, transport, days, price);
	}

	@Override
	public String toString() {
		return "Тур: " +
				"" + places +
				"\n\tтип тура = " + type +
				"\n\tпитание = " + food +
				"\n\tтранспорт = " + transport +
				"\n\tколичество дней = " + days +
				"\n\tцена = " + price + "$";
	}
}
