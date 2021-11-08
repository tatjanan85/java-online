package by.jonline.module2.decomposition;

/**
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */
public class Task11 {
	public static void main(String[] args) {

		int a = 54115;
		int b = 4343151;

		printNumberWithMoreDigits(a, b);
	}

	public static int countDigits(int value) {
		return (int) Math.ceil(Math.log10(value + 0.5));
	}

	public static void printNumberWithMoreDigits(int a, int b) {
		int countA = countDigits(a);
		int countB = countDigits(b);

		if (countA > countB) {
			System.out.printf("В числе %d больше цифр, чем в %d", a, b);
		} else if (countA < countB) {
			System.out.printf("В числе %d больше цифр, чем в %d", b, a);
		} else {
			System.out.println("Длины чисел равны");
		}
	}
}
