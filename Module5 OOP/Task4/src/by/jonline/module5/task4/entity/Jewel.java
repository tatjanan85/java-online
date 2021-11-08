package by.jonline.module5.task4.entity;

import java.util.Objects;
import java.util.Random;

public class Jewel extends Treasure{

	private int value;

	public Jewel(JewelType type) {
		super(type);

		//для драгоценных камней одного вида, но разного размера
		Random random = new Random();
		this.value = type.getValue() + random.nextInt(10);
	}

	@Override
	public int getWorth() {
		return value * 3;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Jewel)) return false;
		Jewel jewel = (Jewel) o;
		return value == jewel.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return getType().toString() + ", стоимость = " + getWorth();
	}
}
