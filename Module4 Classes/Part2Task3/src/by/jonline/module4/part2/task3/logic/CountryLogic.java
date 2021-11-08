package by.jonline.module4.part2.task3.logic;

import by.jonline.module4.part2.task3.entity.City;
import by.jonline.module4.part2.task3.entity.Country;
import by.jonline.module4.part2.task3.entity.District;
import by.jonline.module4.part2.task3.entity.Region;

import java.util.ArrayList;
import java.util.List;

public class CountryLogic {

	public List<District> getDistricts(Country country) {
		List<District> districts = new ArrayList<District>();

		for (Region region: country.getRegions()) {
			districts.addAll(region.getDistricts());
		}
		return districts;
	}

	public int getArea(Country country) {
		int area = 0;

		for (Region region : country.getRegions()) {
			area += region.getArea();
		}
		return area;
	}

	public List<City> getRegionsCenters(Country country) {
		List<City> centers = new ArrayList<City>();

		for (Region region : country.getRegions()) {
			centers.add(region.getCenter());
		}
		return centers;
	}
}
