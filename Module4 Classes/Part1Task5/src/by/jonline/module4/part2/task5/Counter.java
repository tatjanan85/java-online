package by.jonline.module4.part2.task5;

public class Counter {

	private int state;
	private static final int MIN_VALUE = 5;
	private static final int MAX_VALUE = 30;

	public Counter() {
		this.state = MIN_VALUE;
	}

	public Counter(int state) {
		if (state <= 30 && state >= 5) {
			this.state = state;
		} else {
			this.state = MIN_VALUE;
		}
	}

	public int getState() {
		return state;
	}

	public static int getMinValue() {
		return MIN_VALUE;
	}

	public static int getMaxValue() {
		return MAX_VALUE;
	}

	public int incrementAndGet() {
		return (state + 1 <= MAX_VALUE) ? ++state : state;
	}

	public int decrementAndGet() {
		return (state - 1 >= MIN_VALUE) ? --state : state;
	}
}
