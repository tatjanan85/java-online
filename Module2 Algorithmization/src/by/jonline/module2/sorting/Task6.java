package by.jonline.module2.sorting;

import static by.jonline.module2.array.ArrayCreator.createPositiveArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai ≤ ai+1 , то продвигаются
 * на один элемент вперед. Если ai > ai+1 , то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */
public class Task6 {

	public static void main(String[] args) {

		int length = 10;

		int[] array = createPositiveArray(length);
		printArray(array);

		System.out.println("Сортировка по возрастанию:");
		shellaSort(array);
		printArray(array);
	}

	public static void shellaSort(int[] array) 	{
		int i = 0;
		while (i != array.length - 1) {
			if (array[i] < array[i + 1]) {
				i++;
			} else {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;

				if (i != 0) {
					i--;
				}
			}
		}
	}
}
