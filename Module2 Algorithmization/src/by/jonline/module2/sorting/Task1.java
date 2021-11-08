package by.jonline.module2.sorting;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;
/**
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */
public class Task1 {

	public static void main(String[] args) {

		int m = 5;
		int[] array1 = createPositiveArray(m);
		printArray(array1);

		int n = 4;
		int[] array2 = createPositiveArray(n);
		printArray(array2);

		int k = 3;
		int[] newArray = arraysUnion(array1, array2, k - 1);
		printArray(newArray);
	}

	public static int[] arraysUnion(int[] array1, int[] array2, int k) {
		int j = 0, n = 0;
		int[] newArray = new int[array1.length + array2.length];

		for (int i = 0; i < newArray.length; i++) {
			if ((i > k) && (i <= k + array2.length)) {
				newArray[i] = array2[j++];
			} else {
				newArray[i] = array1[n++];
			}
		}
		return newArray;
	}
}
