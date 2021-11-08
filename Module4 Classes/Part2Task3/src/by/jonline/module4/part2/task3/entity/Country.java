package by.jonline.module4.part2.task3.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country {

	private String name;
	private City capital;
	private List<Region> regions = new ArrayList<Region>();

	public Country(String name, City capital) {
		this.name = name;
		this.capital = capital;
	}

	public City getCapital() {
		return capital;
	}

	public String getName() {
		return name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public void addRegion(Region region) {
		regions.add(region);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Country)) return false;
		Country country = (Country) o;
		return Objects.equals(name, country.name) && Objects.equals(capital, country.capital) && Objects.equals(regions, country.regions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, capital, regions);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"name='" + name + '\'' +
				", capital=" + capital +
				", regions=" + regions +
				'}';
	}
}
