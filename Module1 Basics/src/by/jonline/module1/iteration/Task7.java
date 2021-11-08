package by.jonline.module1.iteration;

/**
 * Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
 * m и n вводятся с клавиатуры.
 */
public class Task7 {

	public static void main(String[] args) {

		int m = 20;
		int n = 25;

		for (int i = m; i <= n; i++) {
			int number = i;
			int count = 0;

			System.out.printf("\nДелители числа %d: ", number);

			for (int j = 2; j < number; j++) {
				if (number % j == 0) {
					System.out.print(" " + j);
					count++;
				}
			}

			if (count == 0) {
				System.out.print(" только 1 и само число");
			}
		}
	}

}
