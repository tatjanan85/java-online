package by.jonline.module1.iteration;

import static java.lang.Math.*;

/**
 * Даны два числа. Определить цифры, входящие в запись как первого так и второго числа
 */
public class Task8 {

	public static void main(String[] args) {

		int m = 123456;
		int n = 2578;
		printDigits(m, n);

		m = 123456;
		n = 9878;
		printDigits(m, n);
	}

	public static void printDigits(int m, int n) {
		int mLength = (int) Math.ceil(Math.log10(m + 0.5));
		int mDivider = (int) pow(10, mLength - 1);

		int nLength = (int) Math.ceil(Math.log10(n + 0.5));
		int nDivider = (int) pow(10, nLength - 1);

		boolean haveGigits = false;
		System.out.print("\nОбщие цифры чисeл " + m + ", " + n + ": ");

		for (int i = 1; i <= mLength; i++) {
			int intPartM = m / mDivider;

			int tempN = n;
			int tempNDivider = nDivider;

			for (int j = 1; j <= nLength; j++) {
				int intPartN = tempN / tempNDivider;

				if (intPartN == intPartM) {
					System.out.print(intPartN + " ");
					haveGigits = true;
				}

				tempN-= intPartN * tempNDivider;
				tempNDivider /= 10;
			}

			m -= intPartM * mDivider;
			mDivider /= 10;
		}

		if (! haveGigits) {
			System.out.println("общих цифр нет");
		}
	}
}
