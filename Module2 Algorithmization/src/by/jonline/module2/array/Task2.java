package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 * числом. Подсчитать количество замен.
 */
public class Task2 {
	public static void main(String[] args) {

		int length = 10;
		int z = 5;

		int[] array = createPosNegArray(length);
		printArray(array);

		replaceElements(array, z);
		printArray(array);
	}

	public static void replaceElements(int[] array, int z) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > z) {
				array[i] = z;
				count++;
			}
		}
		System.out.println("Количество замен = " + count);
	}
}
