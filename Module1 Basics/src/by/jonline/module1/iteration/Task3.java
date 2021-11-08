package by.jonline.module1.iteration;

/**
 * Найти сумму квадратов первых ста чисел
 */
public class Task3 {

	public static void main(String[] args) {
		System.out.println("Сумма первых 100 чисел = " + sum100());
	}

	public static int sum100() {
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}

		return sum;
	}
}
