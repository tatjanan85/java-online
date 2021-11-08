package by.jonline.module4.part2.task5;

import by.jonline.module4.part2.task5.entity.Tour;
import by.jonline.module4.part2.task5.entity.tourParameter.Food;
import by.jonline.module4.part2.task5.entity.tourParameter.Place;
import by.jonline.module4.part2.task5.entity.tourParameter.Transport;
import by.jonline.module4.part2.task5.entity.tourParameter.Type;
import by.jonline.module4.part2.task5.logic.TourLogic;
import by.jonline.module4.part2.task5.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 * различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class Main {

	public static void main(String[] args) {
		Tour tour1 = new Tour(Type.HOLIDAY, Food.AI, Transport.PLAINE, 10, 900);
		List<Place> places1 = new ArrayList<Place>();
		places1.add(new Place("Анталия","Турция"));
		tour1.setPlaces(places1);

		Tour tour2 = new Tour(Type.EXCURCION, Food.BB, Transport.BUS, 6, 700);
		List<Place> places2 = new ArrayList<Place>();
		places2.add(new Place("Париж","Франция"));
		places2.add(new Place("Берлин","Германия"));
		tour2.setPlaces(places2);

		Tour tour3 = new Tour(Type.EXCURCION, Food.BB, Transport.BUS, 5, 500);
		List<Place> places3 = new ArrayList<Place>();
		places3.add(new Place("Варшава","Польша"));
		places3.add(new Place("Берлин","Германия"));
		tour3.setPlaces(places3);

		List<Tour> tours = new ArrayList<Tour>();
		tours.add(tour1);
		tours.add(tour2);
		tours.add(tour3);

		// печать всех туров
		View view = new View();
		view.printTours(tours);

		TourLogic tourLogic = new TourLogic();

		//сортировка по дням и вывод на печать
		tours = tourLogic.sortByDays(tours);
		System.out.println("Сортировка туров по количеству дней, по взрастанию:");
		view.printTours(tours);

		//сортировка по цене и вывод на печать
		tours = tourLogic.sortByPrice(tours);
		System.out.println("Сортировка туров по цене, по возрастанию:");
		view.printTours(tours);

		//поиск всех экскурсионных туров
		Type searchType = Type.EXCURCION;
		tourLogic.search(tours, searchType, null, null, null, null, null);

		//поиск всех туров с ценой ниже 600
		int searchPrice = 600;
		tourLogic.search(tours, searchType, null, null, null, null, searchPrice);

		//поиск туров с местом пребывания Берлин
		List<Place> searchPlaces = new ArrayList<Place>();
		searchPlaces.add(new Place("Берлин", "Германия"));
		tourLogic.search(tours, searchType, null, null, searchPlaces, null, null);

	}
}
