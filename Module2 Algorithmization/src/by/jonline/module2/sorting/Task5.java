package by.jonline.module2.sorting;


import static by.jonline.module2.array.ArrayCreator.createPositiveArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Сортировка вставками. Дана последовательность чисел a1,a2,...,an . Требуется переставить числа в порядке
 * возрастания. Делается это следующим образом. Пусть a1,a2,...,ai - упорядоченная последовательность, т. е.
 * a1 ≤ a2 ≤ ... ≤ an . Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
 * последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
 * не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
 * с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */
public class Task5 {

	public static void main(String[] args) {

		int length = 10;

		int[] array = createPositiveArray(length);
		printArray(array);

		System.out.print("\nСортировка по возрастанию:");
		insertionSort(array);
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int element = array[i];

			int index = binarySearch(array, element, 0, i - 1);
			if (index != -1) {
				System.out.println("\nвставка " + element + " в позицию " + index);
			} else {
				System.out.println("\nвставка " + element + " в позицию " + i);
			}

			if (index > -1) {
				for (int j = i; j > index; j--) {
					array[j] = array[j - 1];
				}

				array[index] = element;
			}

			printArray(array);
		}
	}

	public static int binarySearch(int[] array, int value, int start, int end) {
		int left = start;
		int right = end;

		if (right - left == 0 && value < array[left]) {
			return left;
		}

		while (left < right) {
			int middle = (left + right) / 2;

			if (array[middle] > value) {
				right = middle;
			} else {
				left = middle + 1;
			}

			if (right - left == 0 && value < array[right]) {
				return right;
			}
		}
		return -1;
	}
}
