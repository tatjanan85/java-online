package by.jonline.module4.part1.task7;

import by.jonline.module4.part1.task7.entity.Point;
import by.jonline.module4.part1.task7.entity.Triangle;
import by.jonline.module4.part1.task7.logic.TriangleLogic;

/**
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
 * площади, периметра и точки пересечения медиан.
 */
public class Main {

	public static void main(String[] args) {
		Point a = new Point(1, 1);
		Point b = new Point(7, 1);
		Point c = new Point(4, 4);

		Triangle triangle = new Triangle(a, b, c);
		System.out.println(triangle);

		TriangleLogic triangleLogic = new TriangleLogic();
		System.out.printf("Периметр треугольника = %4.1f", triangleLogic.getPerimeter(triangle));
		System.out.printf("\nПлощадь треугольника = %4.1f", triangleLogic.getArea(triangle));

		Point m = triangleLogic.getMedianIntersectionPoint(triangle);
		System.out.printf("\nТочка пересечения медиан = (%3.1f; %3.1f)", m.getX(), m.getY());
	}
}
