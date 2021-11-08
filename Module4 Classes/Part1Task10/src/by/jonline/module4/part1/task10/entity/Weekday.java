package by.jonline.module4.part1.task10.entity;

public enum Weekday {
	MONDAY("пн"),
	TUESDAY("вт"),
	WEDNESDAY("ср"),
	THIRSDAY("чт"),
	FRIDAY("пт"),
	SATURDAY("сб"),
	SUNDAY("вс");

	private String rusName;

	Weekday(String rusName) {
		this.rusName = rusName;
	}

	@Override
	public String toString() {
		return rusName;
	}
}
