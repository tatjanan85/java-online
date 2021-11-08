package by.jonline.module2.sorting;

import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Даны две последовательности
 * a1 ≤ a2 ≤ ... ≤ an и b1 ≤ b2 ≤ ... ≤ bm. Образовать из них новую последовательность
 * чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */
public class Task2 {
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 6, 10};
		int[] b = {2, 4, 8, 9, 11, 12};

		printArray(a);
		printArray(b);

		int[] ab = createArraysUnion(a, b);
		printArray(ab);
	}

	public static int[] createArraysUnion(int[] array1, int[] array2) {
		int[] newArray = new int[array1.length + array2.length];
		int n = 0, m = 0;

		for (int i = 0; i < newArray.length; i++) {
			if (n >= array2.length) {
				newArray[i] = array1[m++];
			} else if (m >= array1.length) {
				newArray[i] = array2[n++];
			} else if  (array1[m] < array2[n]) {
				newArray[i] = array1[m++];
			} else {
				newArray[i] = array2[n++];
			}
		}
		return newArray;
	}
}
