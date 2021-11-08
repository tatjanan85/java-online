package by.jonline.module5.task5.entity;

public enum WaffleType {
	CREAMY("Вафли сливочные", 1, 20),
	CHOCOLATE("Вафли шоколадные", 2, 25);

	private String name;
	private int value;
	private int weight;

	WaffleType(String name, int value, int weight) {
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
