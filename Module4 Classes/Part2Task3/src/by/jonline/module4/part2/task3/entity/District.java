package by.jonline.module4.part2.task3.entity;

import java.util.Objects;

public class District {
	private String name;
	private City center;

	public District(String name, City center) {
		this.name = name;
		this.center = center;
	}

	public City getCenter() {
		return center;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof District)) return false;
		District district = (District) o;
		return Objects.equals(name, district.name) && Objects.equals(center, district.center);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, center);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{" +
				"name='" + name + '\'' +
				", center=" + center +
				'}';
	}
}
