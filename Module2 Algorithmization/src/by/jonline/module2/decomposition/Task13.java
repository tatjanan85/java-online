package by.jonline.module2.decomposition;

/**
 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
 * решения задачи использовать декомпозицию.
 */
public class Task13 {

	public static void main(String[] args) {

		int n = 10;

		printTwinsPrimes(n);
	}

	public static void printTwinsPrimes(int n) {
		int count = 0;
		System.out.printf("Числа-близнецы на отрезке [%d; %d]:", n, 2 * n);

		for (int i = n; i <= 2 * n; i++) {
			if (isPrime(i)) {
				if ((i + 2 <= 2 * n) && isPrime(i + 2)) {
					System.out.printf("\n%d и %d", i, i + 2);
					count++;
				}
			}
		}

		if (count == 0) {
			System.out.printf("\nНа отрезке [%d; %d] числа-близнецы не найдены", n, 2 * n);
		}
	}

	public static boolean isPrime(int index) {
		if (index == 0) return false;
		if (index == 1) return true;

		for (int i = 2; i < index; i++) {
			if (index % i == 0) {
				return false;
			}
		}
		return true;
	}
}
