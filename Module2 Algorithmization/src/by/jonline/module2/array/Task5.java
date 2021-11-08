package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.createPositiveArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i
 */
public class Task5 {

	public static void main(String[] args) {

		int length = 10;

		int[] array = {1, 2, 5, 7, 0, 2, 3, 9};
		printArray(array);

		printNumbers(array);
	}

	public static void printNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) {
				System.out.print(array[i] + " ");
			}
		}
	}
}
