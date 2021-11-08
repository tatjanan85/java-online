package by.jonline.module2.decomposition;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
 * которое меньше максимального элемента массива, но больше всех других элементов).
 */
public class Task5 {

	public static void main(String[] args) {

		int n = 10;

		int[] array = createPositiveArray(n);
		printArray(array);

		sort(array);
		int value = findSecondMaxNumber(array);

		if (value >= 0) {
			System.out.println("Второе по величине число в последовательности " + value);
		} else {
			System.out.println("Все числа последовательности равны");
		}
	}

	//массив уже должен быть отсортирован
	public static int findSecondMaxNumber(int[] array) {
		int max = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] < max)
				return array[i];
		}
		return -1;
	}

	public static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}


