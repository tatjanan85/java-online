package by.jonline.module1.iteration;

/**
 * Составить программу нахождения произведения квадратов первых двухсот чисел
 */
public class Task4 {

	public static void main(String[] args) {
		printProductOfSquares();
	}

	public static void printProductOfSquares() {
		long product = 1;

		for (int i = 2; i <= 50; i++) {
			if (Integer.MAX_VALUE - product > i * i) {
				product *= i * i;
			} else {
				System.out.println("Задача не может быть решена из-за ситуации переполнения типа long");
				System.out.println("Посчитано произведение квадратов первых " + (i - 1) + " чисел");
				break;
			}
		}
		System.out.println("Текущее значение = " + product);
	}
}
