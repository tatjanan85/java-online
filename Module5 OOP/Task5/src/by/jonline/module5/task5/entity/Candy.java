package by.jonline.module5.task5.entity;

public class Candy extends Sweet{
	private int weight;
	private int value;

	public Candy(CandyType type) {
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
		return value;
	}



}
