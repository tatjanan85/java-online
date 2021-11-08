package by.jonline.module2.decomposition;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;
/**
 * Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
 * массива с номерами от k до m.
 */
public class Task8 {

	public static void main(String[] args) {

		int n = 10;
		int[] array = createPositiveArray(n);
		printArray(array);

		System.out.println("D[1] + D[2] + D[3] = " + sumOfTreeArrayElements(array, 1));
		System.out.println("D[3] + D[4] + D[5] = " + sumOfTreeArrayElements(array, 3));
		System.out.println("D[4] + D[5] + D[6] = " + sumOfTreeArrayElements(array, 4));
	}

	public static int sumOfTreeArrayElements(int[] array, int k) {
		int sum = 0;
		int m = k + 3;

		for (int i = k; i < m; i++) {
			sum += array[i];
		}
		return sum;
	}
}
