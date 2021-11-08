package by.jonline.module4.part2.task5.view;

import by.jonline.module4.part2.task5.entity.Tour;
import by.jonline.module4.part2.task5.entity.tourParameter.Food;
import by.jonline.module4.part2.task5.entity.tourParameter.Place;
import by.jonline.module4.part2.task5.entity.tourParameter.Transport;
import by.jonline.module4.part2.task5.entity.tourParameter.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View {

	public void printTours(List<Tour> tours) {
		System.out.println("----------------------------------");
		System.out.println("Результаты поиска:");
		for (Tour tour : tours) {
			System.out.println(tour);
		}
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
	}

	public void printSearchResults(List<Tour> results, Type type, Food food,
								   Transport transport, List<Place> places, Integer days, Integer maxPrice) {
		System.out.println("КРИТЕРИИ ПОИСКА: ");

		if (type != null) {
			System.out.println("тип тура: " + type);
		} else {
			System.out.println("тип тура: критерий не задан");
		}

		if (food != null) {
			System.out.println("питание: " + food);
		} else {
			System.out.println("питание: критерий не задан" );
		}

		if (transport != null) {
			System.out.println("транспорт: " + transport);
		} else {
			System.out.println("питание: критерий не задан" );
		}

		if (places != null) {
			System.out.println("города: " + places);
		} else {
			System.out.println("города: критерий не задан" );
		}

		if (days != null) {
			System.out.println("количество дней: " + days);
		} else {
			System.out.println("количество дней: критерий не задан" );
		}

		if (maxPrice != null) {
			System.out.println("максимальная стоимость: " + maxPrice);
		} else {
			System.out.println("максимальная стоимость: критерий не задан" );
		}

		printTours(results);
	}
}
