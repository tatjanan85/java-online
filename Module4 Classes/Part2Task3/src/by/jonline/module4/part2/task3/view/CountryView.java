package by.jonline.module4.part2.task3.view;

import by.jonline.module4.part2.task3.entity.Country;
import by.jonline.module4.part2.task3.logic.CountryLogic;

public class CountryView {

	private CountryLogic logic = new CountryLogic();

	public void printCapital(Country country) {
		System.out.printf("Столица государства %s - город %s\n", country.getName(), country.getCapital());
	}

	public void printRegionsAmount(Country country) {
		System.out.println("Количество областей = " + country.getRegions().size());
	}

	public void printArea(Country country) {
		System.out.println("Площадь = " + logic.getArea(country));
	}

	public void printRegionsCenters(Country country) {
		System.out.println("Областные центры: " + logic.getRegionsCenters(country));
	}
}
