package by.jonline.module4.part2.task3;

import by.jonline.module4.part2.task3.entity.City;
import by.jonline.module4.part2.task3.entity.Country;
import by.jonline.module4.part2.task3.entity.Region;
import by.jonline.module4.part2.task3.view.CountryView;

/**
 * Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
 * столицу, количество областей, площадь, областные центры
 */
public class Main {

	public static void main(String[] args) {
		Country belarus = new Country("Беларусь", new City("Минск"));
		belarus.addRegion(new Region("Брестская", new City("Брест"), 32786));
		belarus.addRegion(new Region("Витебская", new City("Витебск"), 40051));
		belarus.addRegion(new Region("Гомельская", new City("Гомель"), 40372));
		belarus.addRegion(new Region("Гродненская", new City("Гродно"), 25127));
		belarus.addRegion(new Region("Минская", new City("Минск"), 39854));
		belarus.addRegion(new Region("Могилёвская", new City("Могилёв"), 29068));

		CountryView view = new CountryView();
		view.printCapital(belarus);
		view.printArea(belarus);
		view.printRegionsAmount(belarus);
		view.printRegionsCenters(belarus);
	}
}
