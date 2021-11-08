package by.jonline.module5.task5.entity;

public class Chocolate extends Sweet {

	private int weight;
	private int value;

	public Chocolate(ChocolateType type) {
		super(type);
		this.weight = type.getWeight();
		this.value = type.getValue();
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public int getWorth() {
		return value * 6;
	}

}
