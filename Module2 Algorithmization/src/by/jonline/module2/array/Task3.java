package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */
public class Task3 {
	public static void main(String[] args) {

		int n = 10;

		int[] array = createPosNegArray(n);
		printArray(array);

		count(array);
	}

	public static void count(int[] array) {
		int positive = 0;
		int negative = 0;
		int zero = 0;

		for (int element : array) {
			if (element > 0) {
				positive++;
			} else if (element < 0) {
				negative++;
			} else {
				zero++;
			}
		}

		System.out.println("Положительных элементов = " + positive);
		System.out.println("Отрицательных элементов = " + negative);
		System.out.println("Нулевых элементов = " + zero);
	}
}
