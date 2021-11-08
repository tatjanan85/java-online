package by.jonline.module1.condition;

/**
 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z  кирпича.
 * Определить, пройдет ли кирпич через отверстие.
 */
public class Task4 {

	public static void main(String[] args) {

		int a = 10;
		int b = 15;
		System.out.printf("Размеры отверстия %d x %d\n", a, b);

		int x = 20;
		int y = 14;
		int z = 8;
		System.out.printf("Размеры кирпича %d x %d x %d\n", x, y, z);

		System.out.println("Кирпич пройдёт через отверстие? - " + checkBrick(a, b, x, y ,z));
	}

	public static boolean checkBrick(int a, int b, int x, int y, int z) {
		if ((x <= a) && (y <= b) || (y <= b) && (y <= a))
			return true;
		if ((x <= a) && (z <= b) || (z <= a) && (x <= b))
			return true;
		if ((y <= a) && (z <= b) || (z <= a) && (y <= b))
			return true;
		return false;
	}


}
