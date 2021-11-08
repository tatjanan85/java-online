package by.jonline.module5.task4.entity;

import java.util.Objects;

public class Coin extends Treasure{

	private int value;

	public Coin(CoinType type) {
		super(type);
		this.value = type.getValue();
	}

	@Override
	public int getWorth() {
		return value * 2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Coin)) return false;
		Coin coin = (Coin) o;
		return value == coin.value;
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
