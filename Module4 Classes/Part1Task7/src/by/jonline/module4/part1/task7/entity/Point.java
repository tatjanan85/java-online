package by.jonline.module4.part1.task7.entity;

public class Point {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + x  + "; " + y +
				']';
	}
}
