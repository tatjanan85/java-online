package by.jonline.module4.part2.task3.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Region {

	private String name;
	private City center;
	private int area;
	private List<District> districts = new ArrayList<District>();

	public Region(String name, City center) {
		this.name = name;
		this.center = center;
	}

	public Region(String name, City center, int area) {
		this.name = name;
		this.center = center;
		this.area = area;
	}

	public City getCenter() {
		return center;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public void addDistrict(District district) {
		districts.add(district);
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Region)) return false;
		Region region = (Region) o;
		return area == region.area && Objects.equals(name, region.name) && Objects.equals(center, region.center) && Objects.equals(districts, region.districts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, center, area, districts);
	}

	@Override
	public String toString() {
		return "Region{" +
				"name='" + name + '\'' +
				", center=" + center +
				", area=" + area +
				", districts=" + districts +
				'}';
	}
}
