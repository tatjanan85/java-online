package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Дана последовательность целых чисел a1,a2,...,an . Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min(a1,a2,...,an) .
 */
public class Task8 {

	public static void main(String[] args) {

		int[] array = {0, 10, 50, 0, 100, 0, 200};
		printArray(array);

		int min = min(array);
		System.out.println("Минимальный элемент = " + min);

		int[] newArray = createArrayWithoutMin(array, min);
		printArray(newArray);
	}

	public static int min(int[] array) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static int[] createArrayWithoutMin(int[] array, int min) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) {
				count++;
			}
		}

		int[] newArray = new int[array.length - count];

		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != min) {
				newArray[j] = array[i];
				j++;
			}
		}
		return newArray;
	}
}
