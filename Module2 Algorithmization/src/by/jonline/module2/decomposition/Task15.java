package by.jonline.module2.decomposition;

/**
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */
public class Task15 {

	public static void main(String[] args) {
		int n = 2;

		printNumbers(n);
	}

	public static void printNumbers(int n) {
		int start = (int) Math.pow(10, n - 1);

		for (int i = start; i < start * 10; i++) {
			int prevNumber = 0;
			String number = "";

			for (int j = 0; j < n; j++) {
				int digit = findDigitN(i, j + 1);

				if (digit > prevNumber) {
					number += digit;
					prevNumber = digit;
				} else {
					break;
				}
			}
			if (number.length() == n) {
				System.out.print(number + " ");
			}
		}
	}

	public static int findDigitN(int value, int position) {
		int digits = countDigits(value);
		int digit = value;

		for (int i = 0; i <= digits - position; i++) {
			digit = value % 10;
			value /= 10;
		}
		return digit;
	}

	public static int countDigits(int value) {
		return String.valueOf(value).length();
	}
}
