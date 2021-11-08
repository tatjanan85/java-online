package by.jonline.module4.part2.task5.entity.tourParameter;

public enum Food {
	OB("без питания"),
	BB("завтраки"),
	HB("завтраки и ужины"),
	AI("всё включено");

	String name;

	Food(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
