package by.jonline.module4.part2.task5.entity.tourParameter;

import java.util.Objects;

public class Place {
	private String name;
	private String country;

	public Place(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Place)) return false;
		Place place = (Place) o;
		return Objects.equals(name, place.name) && Objects.equals(country, place.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, country);
	}

	@Override
	public String toString() {
		return name + "/" + country;
	}


}
