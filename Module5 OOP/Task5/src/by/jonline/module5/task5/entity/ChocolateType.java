package by.jonline.module5.task5.entity;

public enum ChocolateType {
	MILK("Шоколад молочный", 1, 50),
	RAISIN("Шоколад с изюмом", 2, 60),
	NUTTY("Шоколад с орехами", 3, 70);


	private String name;
	private int value;
	private int weight;

	ChocolateType(String name, int value, int weight) {
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
