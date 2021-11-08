package by.jonline.module2.decomposition;

import java.util.Scanner;

/**
 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
 * если угол между сторонами длиной X и Y— прямой.
 */
public class Task9 {

	public static void main(String[] args) {

		double x = 10;
		double y = 20;
		double z = 30;
		double t = 40;

		double area = quadrangleArea(x, y, z, t);

		if (!Double.isNaN(area)) {
			System.out.printf("Площадь четырехугольника = %6.2f", area);
		} else {
			System.out.println("Четырёхугольника с такими сторонами не существует");
		}
	}

	public static double quadrangleArea(double x, double y, double z, double t) {
		double leg = findTriangleLeg(x, y);
		return triangleArea(x, y, leg) + triangleArea(leg, z, t);
	}

	public static double findTriangleLeg(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	public static double trianglePerimeterHalf(double a, double b, double c) {
		return (a + b + c) / 2;
	}

	public static double triangleArea(double a, double b, double c) {
		double p = trianglePerimeterHalf(a, b, c);
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}
