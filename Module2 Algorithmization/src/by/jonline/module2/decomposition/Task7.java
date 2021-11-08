package by.jonline.module2.decomposition;

/**
 * Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9
 */
public class Task7 {

	public static void main(String[] args) {
		System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9 = " + sumOfFactorials());
	}

	//сумма факториалов
	public static int sumOfFactorials() {
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			if (isOdd(i)) {
				sum += factorial(i);
			}
		}

		return sum;
	}

	//проверка на нечётность
	public static boolean isOdd(int value) {
		return (value % 2 == 1) ? true : false;
	}

	//факториал числа
	public static int factorial(int value) {
		int factorial = 1;

		for (int i = 2; i <= value; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
