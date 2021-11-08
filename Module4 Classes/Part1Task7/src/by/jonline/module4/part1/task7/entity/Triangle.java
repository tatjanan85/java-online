package by.jonline.module4.part1.task7.entity;

public class Triangle {

	private Point a;
	private Point b;
	private Point c;

	public Triangle() {
	}

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Треугольник с вершинами: {" +
				" a = " + a +
				", b = " + b +
				", c = " + c +
				'}';
	}
}
