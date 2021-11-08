package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.*;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */
public class Task4 {

	public static void main(String[] args) {

		int length = 10;

		int[] array = createPosNegArray(length);
		printArray(array);

		int indexMax = indexMax(array);
		int indexMin = indexMin(array);

		exchange(array, indexMax, indexMin);
		printArray(array);
	}

	public static int indexMax(int[] array) {
		int max = Integer.MIN_VALUE;
		int indexMax = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				indexMax = i;
			}
		}
		System.out.println("Максимальный элемент = " + max);
		return  indexMax;
	}

	public static int indexMin(int[] array) {
		int min = Integer.MAX_VALUE;
		int indexMin = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				indexMin = i;
			}
		}
		System.out.println("Минимальный элемент = " + min);
		return  indexMin;
	}

	public static void exchange(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
