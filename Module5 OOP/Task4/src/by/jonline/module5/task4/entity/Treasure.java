package by.jonline.module5.task4.entity;

public abstract class Treasure {
	private Enum type;

	public Treasure(Enum type) {
		this.type = type;
	}

	public Enum getType() {
		return type;
	}

	public abstract int getWorth();
}
