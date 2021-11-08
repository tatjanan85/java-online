package by.jonline.module5.task5.entity;

import java.util.Objects;

public abstract class Sweet implements Comparable {
	private Enum type;

	public Sweet(Enum type) {
		this.type = type;
	}

	public Enum getType() {
		return type;
	}

	public abstract int getWeight();

	public abstract int getValue();

	public abstract int getWorth();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Sweet)) return false;
		Sweet sweet = (Sweet) o;
		return Objects.equals(type, sweet.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public String toString() {
		return type.toString();
	}

	@Override
	public int compareTo(Object o) {
		Sweet sweet = (Sweet) o;
		return getType().toString().compareTo(sweet.getType().toString());
	}
}
