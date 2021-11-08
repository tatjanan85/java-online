package by.jonline.module2.sorting;

import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Пусть даны две неубывающие последовательности действительных чисел a1 ≤ a2 ≤ ... ≤ an и b1 ≤ b2 ≤ ... ≤ bm .
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 ≤ b2 ≤ ... ≤ bm в первую
 * последовательность так, чтобы новая последовательность оставалась возрастающей.
 */
public class Task7 {

	public static void main(String[] args) {

		int[] array1 = {1, 6, 8, 10};
		int[] array2 = {2, 3, 7, 9, 11};

		printArray(array1);
		printArray(array2);

		printPositions(array1, array2);
	}

	public static void printPositions(int[] array1, int[] array2) {
		int[] newArray = new int[array1.length];
		System.arraycopy(array1, 0, newArray, 0, array1.length);

		System.out.println("\nВставки:");

		//находим позицию для вставки каждого элемента 2-го массива
		for (int j = 0; j < array2.length; j++) {

			//создаем массив длинной на 1 больше для вставки элемента
			newArray = new int[newArray.length + 1];
			System.arraycopy(array1, 0, newArray, 0, array1.length);

			//перебираем каждый элемент 1-го массива, чтобы найти позицию для вставки
			for (int i = 0; i < newArray.length - 1; i++) {
				if (array2[j] < newArray[i]) {

					// если позиция найдена, осуществляем сдвиг элементов и вставку
					for (int k = newArray.length - 1; k >= 0; k--) {
						if (k > i) {
							newArray[k] = newArray[k - 1];
						} else if (k == i) {
							newArray[i] = array2[j];
						}
					}

					System.out.println("Элемент " + array2[j] + " вставляется в позицию " + (i + 1));
					break;
				}
			}

			//осуществляем вставку в свободную позицию в случае, если позиция не была найдена ранее
			if (newArray[newArray.length - 1] == 0) {
				newArray[newArray.length - 1] = array2[j];
				System.out.println("Элемент " + array2[j] + " вставляется в позицию " + (newArray.length));
			}

			array1 = newArray;
			System.out.println("---------------------------------");
			printArray(newArray);
		}
	}
}
