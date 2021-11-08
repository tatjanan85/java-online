package by.jonline.module5.task4.entity;

public enum JewelType {
	DIAMOND("Бриллиант", 20), RUBY("Рубин", 15), SAPPHIRE("Сапфир", 10), EMERALD("Изумруд", 5);

	private String name;
	private int value;

	JewelType (String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name;
	}
}
