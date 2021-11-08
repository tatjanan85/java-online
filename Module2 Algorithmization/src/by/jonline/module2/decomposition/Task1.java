package by.jonline.module2.decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 * натуральных чисел:
 */
public class Task1 {

	public static void main(String[] args) {
		int a = 24;
		int b = 32;

		System.out.println("Наибольший общий делитель = " + findNOD(a, b));
		System.out.println("Наименьшее общее кратное = " + findNOK(a, b));
	}

	public static int findNOD(int a, int b) {
		while(b != 0) {
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}

	//для натуральных a и b метод abs необязателен
	public static int findNOK (int a, int  b) {
		return Math.abs(a * b) / findNOD(a, b);
	}
}
