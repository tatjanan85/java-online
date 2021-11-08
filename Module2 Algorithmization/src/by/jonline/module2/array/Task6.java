package by.jonline.module2.array;

/**
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
 * являются простыми числами.
 */
public class Task6 {
	public static void main(String[] args) {

		int n = 10;
		double[] array = ArrayCreator.createRealArray(n);
		ArrayPrinter.printArray(array);

		double result = Math.round(sum(array) * 100) / 100.0;
		System.out.println("Сумма элементов, индексы которых простые числа = " + result);
	}

	public static double sum(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (isPrime(i)) {
				sum += array[i];
			}
		}
		return sum;
	}

	public static boolean isPrime(int index) {
		if (index == 0)
			return false;

		if (index == 1)
			return true;

		for (int i = 2; i < index; i++) {
			if (index % i == 0) {
				return false;
			}
		}
		return true;
	}
}
