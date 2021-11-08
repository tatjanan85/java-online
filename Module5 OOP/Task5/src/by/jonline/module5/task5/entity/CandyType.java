package by.jonline.module5.task5.entity;

public enum CandyType {
	SUGAR("Конфета леденец", 1, 5),
	TOFFEE("Конфета ириска", 2, 5),
	CHOCOLATE("Конфета шоколадная", 3, 10);

	private String name;
	private int value;
	private int weight;

	CandyType(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return name;
	}
}
