package by.jonline.module2.decomposition;

import by.jonline.module2.array.ArrayPrinter;

/**
 * Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
 * являются цифры числа N.
 */
public class Task10 {
	public static void main(String[] args) {

		int n = 123456789;

		int[] array = createArrayFromInt(n);
		ArrayPrinter.printArray(array);
	}

	public static int[] createArrayFromInt(int value) {
		int size = (int) Math.ceil(Math.log10(value + 0.5));
		int[] array = new int[size];

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = value % 10;
			value /= 10;
		}
		return array;
	}

}
