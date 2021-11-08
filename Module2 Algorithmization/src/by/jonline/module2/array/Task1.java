package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */
public class Task1 {

	public static void main(String[] args) {

		int n = 10;
		int k = 2;

		int[] array = createPositiveArray(n);
		printArray(array);

		System.out.printf("Сумма элементов, кратных %d равна %d", k, sum(array, k));
	}

	public static int sum(int[] array, int k) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] % k == 0)
				sum += array[i];
		}
		return sum;
	}
}
