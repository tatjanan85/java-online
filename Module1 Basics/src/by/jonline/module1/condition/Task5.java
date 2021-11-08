package by.jonline.module1.condition;

import static java.lang.Math.round;

/**
 * Вычислить значение функции:
 * F(x) = x²-3x+9, если х ≤ 3
 * F(x) = 1/(x³+6), если x > 3
 */
public class Task5 {

	public static void main(String[] args) {

		int x = 4;
		System.out.println("Значение х = " + x);
		System.out.println("Значение функции = " + doFunction(x));

		x = 1;
		System.out.println("Значение х = " + x);
		System.out.println("Значение функции = " + doFunction(x));
	}

	public static double doFunction(int x) {
		if (x > 3) {
			return (double) round((double) 1 / (x * x * x + 6) * 1000) / 1000;
		}
		return  x * x - 3 * x + 9;
	}
}
