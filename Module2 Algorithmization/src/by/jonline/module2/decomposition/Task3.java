package by.jonline.module2.decomposition;

import static java.lang.Math.sqrt;
/**
 * Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
 * треугольника.
 */
public class Task3 {

	public static void main(String[] args) {

		int a = 10;

		System.out.printf("Площадь шестиугольника равна = %8.2f", hexagonArea(a));
	}

	public static double hexagonArea(int a) {
		return regularTriangleArea(a) * 6;
	}

	public static double regularTriangleArea(int a) {
		return a * a * sqrt(3) / 4;
	}
}
