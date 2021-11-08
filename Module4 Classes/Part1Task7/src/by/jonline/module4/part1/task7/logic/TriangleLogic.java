package by.jonline.module4.part1.task7.logic;

import by.jonline.module4.part1.task7.entity.Point;
import by.jonline.module4.part1.task7.entity.Triangle;

import static java.lang.Math.*;

public class TriangleLogic {

	public double getPerimeter(Triangle t) {
		double ab = getSideLength(t.getA(), t.getB());
		double bc = getSideLength(t.getB(), t.getC());
		double ac = getSideLength(t.getA(), t.getC());

		return ab + bc + ac;
	}

	//площадь треугольника по формуле S= √ (p * (p - a)*(p - b)*(p - c))
	public double getArea(Triangle t) {
		double ab = getSideLength(t.getA(), t.getB());
		double bc = getSideLength(t.getB(), t.getC());
		double ac = getSideLength(t.getA(), t.getC());

		double p = getPerimeter(t) / 2;

		return sqrt(p * (p - ab) * (p - bc) * (p - ac));
	}

	//длина стороны треугольника по координатам 2-х вершин
	private double getSideLength(Point point1, Point point2) {
		return sqrt(pow(abs(point1.getX() - point2.getX()), 2) + pow(abs(point1.getY() - point2.getY()), 2));
	}

	// точка пересечения медиан
	public Point getMedianIntersectionPoint(Triangle t) {
		Point a = t.getA();
		Point b = t.getB();
		Point c = t.getC();

		//координаты серидины отрезка AB - второй точки медианы
		double middleABX = (a.getX() + b.getX()) / 2;
		double middleABY = (a.getY() + b.getY()) / 2;

		// используем формулу деления отрезка в данном отношении
		// точка пересечения делит медиану в отношении 2:1, начиная от вершины
		double x = (1 * c.getX() + 2 * middleABX) / (1 + 2);
		double y = (1 * c.getY() + 2 * middleABY) / (1 + 2);

		return new Point(x, y);
	}
}
