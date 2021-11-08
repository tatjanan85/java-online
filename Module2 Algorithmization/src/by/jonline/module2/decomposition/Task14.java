package by.jonline.module2.decomposition;

/**
 * Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
 * использовать декомпозицию.
 */
public class Task14 {
	public static void main(String[] args) {

		int k = 1000;

		printArmstrongNumbers(k);
	}

	public static void printArmstrongNumbers(int k) {
		for (int i = 1; i <= k; i++) {
			int digits = countDigits(i);
			int sum = sumOfDigits(i);

			if (Math.pow(sum, digits) == i) {
				System.out.print(i + " ");
			}
		}	
	}	
	
	//количество цифр
	public static int countDigits(int value) {
		return String.valueOf(value).length();
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
