package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */
public class Task9 {

	public static void main(String[] args) {
		int[] array = {1, -2, 0, 0, 2, 3, 5, 5};
		printArray(array);
		System.out.println("Наиболее часто втречающееся число = " + repeatingNumber(array));
	}

	public static int repeatingNumber(int[] array) {
		int max_repeated = 1;
		int max_repeated_number = array[0];

		for (int i = 0; i < array.length; i++) {
			int search = array[i];
			int repeated = 1;

			// находим число повторений заданного элемента
			for (int j = 0; j < array.length; j++) {
				if (i == j)
					continue;
				if (array[i] == array[j]) {
					repeated++;
				}
			}

			//если число повторений > найденного ранее, то заменяем значение
			if (repeated > max_repeated) {
				max_repeated_number = search;
				max_repeated = repeated;

			//если число повторений = найденному ранее, то сравниваем числа и находим наименьшее}
			} else if (repeated == max_repeated) {
				if (search < max_repeated_number) {
					max_repeated_number = search;
				}
			}
		}
		return max_repeated_number;
	}

}
