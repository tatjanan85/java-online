package by.jonline.module2.sorting;

import static by.jonline.module2.array.ArrayCreator.createPositiveArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Сортировка выбором. Дана последовательность чисел a1 ≤ a2 ≤ ... ≤ an .Требуется переставить элементы так,
 * чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
 * элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
 * повторяется. Написать алгоритм сортировки выбором.
 */
public class Task3 {
	public static void main(String[] args) {

		int length = 10;
		int[] array = createPositiveArray(length);
		printArray(array);

		selectionSort(array);
		System.out.println("Сортировка по убыванию");
		printArray(array);
	}

	public static void selectionSort(int[] array) 	{
		for (int i = 0; i < array.length; i++) {
			int max = array[i];
			int max_index = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > max) {
					max = array[j];
					max_index = j;
				}
			}

			int temp = array[i];
			array[i] = array[max_index];
			array[max_index] = temp;
		}
	}
}
