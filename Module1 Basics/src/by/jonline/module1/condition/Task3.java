package by.jonline.module1.condition;

/**
 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
 */
public class Task3 {

	public static void main(String[] args) {

		int x1 = 0;
		int y1 = 0;

		int x2 = 2;
		int y2 = 2;

		int x3 = -1;
		int y3 = -1;

		System.out.println("Точки лежат на одной прямой? - " + checkPoints(x1, y1, x2, y2, x3, y3));

		x3 = -1;
		y3 = 0;

		System.out.println("Точки лежат на одной прямой? - " + checkPoints(x1, y1, x2, y2, x3, y3));
	}

	// точки принадлежат одной прямой, если  выполняется равенство (x2 - x1) / (x3 - x1) == (y2 - y1) / (y3 - y1)
	// во избежание ситуации деления на 0 - от деления перейдём к произведению
	public static boolean checkPoints(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (x2 - x1) * (y3 - y1) == (y2 - y1) * (x3 - x1);
	}
}
