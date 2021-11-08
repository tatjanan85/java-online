package by.jonline.module1.iteration;

/**
 * Вычислить значения функции на отрезке [а,b] c шагом h:
 * y = x, если х > 2
 * y = -x, если х <= 2
 */
public class Task2 {

	public static void main(String[] args) {
		int a = 2;
		int b = 8;
		int h = 2;

		printFunction(a, b, h);
	}

	public static void printFunction(int a, int b, int h) {
		for (int i = a; i <= b; i += h) {
			if (i > 2) {
				System.out.printf("при х = %d y = %d\n", i, i);
			} else {
				System.out.printf("при х = %d y = %d\n", i, -i);
			}
		}
	}
}
