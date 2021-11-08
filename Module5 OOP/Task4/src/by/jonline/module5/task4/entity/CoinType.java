package by.jonline.module5.task4.entity;

public enum CoinType {
	GOLD("Золотая монета", 2), SILVER("Серебряная монета", 1);

	private String name;
	private int value;

	CoinType (String name, int value) {
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
