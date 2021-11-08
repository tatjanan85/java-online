package by.jonline.module2.decomposition;

/**
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
 * действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */
public class Task17 {
	public static void main(String[] args) {

		int k = 77;

		System.out.println("Для получения 0 необходимо произвести " + countActions(k) + " действий");
	}

	public static int countActions(int n) {
		int count = 0;

		while (n != 0) {
			n -= sumOfDigits(n);
			System.out.print(n + " ");
			count++;
		}
		System.out.println();

		return count;
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
