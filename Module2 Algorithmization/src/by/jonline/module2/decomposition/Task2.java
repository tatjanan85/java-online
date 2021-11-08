package by.jonline.module2.decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */
public class Task2 {

	public static void main(String[] args) {

		int a = 24;
		int b = 32;
		int c = 64;
		int d = 128;

		System.out.println("Наибольший общий делитель = " + findNOD4(a,b,c,d));
	}

	public static int findNOD4(int a, int b, int c, int d) {
		int nodAB = findNOD2(a, b);
		int nodCD = findNOD2(c, d);
		int nodABCD = findNOD2(nodAB, nodCD);
		return nodABCD;
	}
	public static int findNOD2(int a, int b) {
		while(b != 0) {
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}
}
