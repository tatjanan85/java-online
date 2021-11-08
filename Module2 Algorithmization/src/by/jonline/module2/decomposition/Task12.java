package by.jonline.module2.decomposition;

import java.util.Random;

import static by.jonline.module2.array.ArrayPrinter.*;

/**
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
 * являются числа, сумма цифр которых равна К и которые не большее N.
 */
public class Task12 {

	public static void main(String[] args) {

		int k = 10;
		int n = 50;

		int length = 10;

		int[] array = createArray(length, k, n);
		printArray(array);
	}

	public static int[] createArray(int length, int k, int n) {
		int[] array = new int[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = generateNumber(k, n);
		}
		return array;
	}

	//генерация числа большего чем n и сумма цифр которого = k
	public static int generateNumber(int k, int n) {
		int number;
		Random random = new Random();

		do {
			number = random.nextInt(n + 1);
		} while (sumOfDigits(number) != k);

		return number;
	}

	//подсчёт суммы цифр в числе
	public static int sumOfDigits(int value) {
		int  sum = 0;

		while (value != 0) {
			sum += value % 10;
			value /= 10;
		}
		return sum;
	}
}
