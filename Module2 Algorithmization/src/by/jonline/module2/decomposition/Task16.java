package by.jonline.module2.decomposition;

/**
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */
public class Task16 {

	public static void main(String[] args) {

		int n = 2;

		System.out.println("Сумма = " + sum(n));
	}

	//сумма всех чисел, содержащих только нечетные цифры
	public static long sum(int n) {
		long sum = 0;
		int start = (int) Math.pow(10, n - 1);

		for (int i = start; i < start * 10; i++) {
			if (isNumberWithOddDigits(i)) {
				System.out.print(i + " ");
				sum += i;
			}
		}
		System.out.println();
		return sum;
	}

	//все ли цифры числа нечётные
	public static boolean isNumberWithOddDigits(int value) {
		int digits = countDigits(value);

		for (int i = 0; i < digits; i++) {
			if (findDigitN(value, i + 1) % 2 == 0) {
				return false;
			}
		}
		return true;
	}

	//цифра на n-й позиции
	public static long findDigitN(long value, int position) {
		int digits = countDigits(value);
		long digit = value;

		for (int i = 0; i <= digits - position; i++) {
			digit = value % 10;
			value /= 10;
		}
		return digit;
	}

	public static int countDigits(long value) {
		return (int) Math.ceil(Math.log10(value + 0.5));
	}
}
