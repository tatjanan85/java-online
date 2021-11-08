package by.jonline.module2.array;

import static by.jonline.module2.array.ArrayCreator.createPositiveArray;
import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать
 */
public class Task10 {

	public static void main(String[] args) {

		int n = 10;

		int[] array = createPositiveArray(n);
		printArray(array);

		modifyArray(array);
		printArray(array);
	}

	public static void modifyArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i % 2 != 0) {
				array[i] = 0;
			}
		}
	}
}


