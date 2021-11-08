package by.jonline.module2.sorting;

import static by.jonline.module2.array.ArrayCreator.createPositiveArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Сортировка обменами. Дана последовательность чисел a1 ≤ a2 ≤...≤ an .Требуется переставить числа в
 * порядке возрастания. Для этого сравниваются два соседних числа ai и ai+1 . Если ai ≤ ai+1 , то делается
 * перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */
public class Task4 {

	public static void main(String[] args) {

		int length = 10;

		int[] array = createPositiveArray(length);
		printArray(array);


		System.out.println("Сортировка по возрастанию:");
		exchangingSort(array);
		printArray(array);
	}

	public static void exchangingSort(int[] array) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					count++;
				}
			}
		}
		System.out.println("Количество перестановок = " + count);
	}
}
