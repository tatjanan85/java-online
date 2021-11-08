package by.jonline.module2.decomposition;

/**
 * Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми
 */
public class Task6 {

	public static void main(String[] args) {
		int a = 77;
		int b = 13;
		int c = 100;

		System.out.println("Числа взаимно простые? " + isPrime(a, b, c));
	}

	//числа взаимно просты, если их наибольший общий делитель = 1
	public static boolean isPrime(int a, int b, int c) {
		return findNOD(findNOD(a, b), c) == 1 ? true : false;
	}

	public static int findNOD(int a, int b) {
		while(b != 0) {
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}
}


