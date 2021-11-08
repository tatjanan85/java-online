package by.jonline.module4.part2.task5.logic;

import by.jonline.module4.part2.task5.entity.Tour;
import by.jonline.module4.part2.task5.entity.tourParameter.Food;
import by.jonline.module4.part2.task5.entity.tourParameter.Place;
import by.jonline.module4.part2.task5.entity.tourParameter.Transport;
import by.jonline.module4.part2.task5.entity.tourParameter.Type;
import by.jonline.module4.part2.task5.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TourLogic {

	private View view = new View();
	public void search(List<Tour> tours, Type type, Food food, Transport transport,
							 List<Place> places, Integer days, Integer maxPrice) {
		List<Tour> results = new ArrayList<Tour>();

		if (type != null) {
			for (Tour tour : tours) {
				if (tour.getType() == type) {
					results.add(tour);
				}
			}
		} else {
			Collections.copy(results, tours);
		}

		if (food != null) {
			for (Tour tour : tours) {
				if (tour.getFood() != food) {
					results.remove(tour);
				}
			}
		}

		if (transport != null) {
			for (Tour tour : tours) {
				if (tour.getTransport() != transport) {
					results.remove(tour);
				}
			}
		}

		if (places != null) {
			for (Tour tour : tours) {
				List<Place> tourPlaces = tour.getPlaces();
				for (Place place : places) {
					if (!tourPlaces.contains(place)) {
						results.remove(tour);
						break;
					}
				}
			}
		}

		if (days != null) {
			for (Tour tour : tours) {
				if (tour.getDays() != days) {
					results.remove(tour);
				}
			}
		}

		if (maxPrice != null) {
			for (Tour tour : tours) {
				if (tour.getPrice() > maxPrice) {
					results.remove(tour);
				}
			}
		}

		view.printSearchResults(results, type, food, transport, places, days, maxPrice);
	}

	public List<Tour> sortByDays(List<Tour> tours) {
		for (int i = 0; i < tours.size() - 1; i++) {
			for (int j = 0; j < tours.size() - 1 - i; j++) {
				if (tours.get(j).getDays() > tours.get(j + 1).getDays()) {
					Tour temp = tours.get(j);
					tours.set(j, tours.get(j + 1));
					tours.set(j + 1, temp);
				}
			}
		}
		return tours;
	}

	public List<Tour> sortByPrice(List<Tour> tours) {
		for (int i = 0; i < tours.size() - 1; i++) {
			for (int j = 0; j < tours.size() - 1 - i; j++) {
				if (tours.get(j).getPrice() > tours.get(j + 1).getPrice()) {
					Tour temp = tours.get(j);
					tours.set(j, tours.get(j + 1));
					tours.set(j + 1, temp);
				}
			}
		}
		return tours;
	}
}
