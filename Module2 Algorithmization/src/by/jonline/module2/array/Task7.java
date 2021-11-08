package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.createPosNegArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Даны действительные числа a1,a2,...,a2n . Найти
 * max( a1 + a2n,a2 + a2n−1,...,an + an+1) .
 */
public class Task7 {
	public static void main(String[] args) {

		int n = 2;
		int[] array = createPosNegArray(n * 2);
		printArray(array);

		int[] halfArray = createHalfArray(array);
		printArray(halfArray);

		System.out.println("Максимум = " + max(halfArray));

	}

	//создание массива, среди элементов которого нужно найти максимум
	public static int[] createHalfArray(int[] array) {
		int[] halfArray = new int[array.length / 2];

		for (int i = 0; i < halfArray.length; i++) {
			halfArray[i] = array[i] + array[array.length - 1 - i];
		}
		return halfArray;
	}

	public static int max(int[] array) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}
