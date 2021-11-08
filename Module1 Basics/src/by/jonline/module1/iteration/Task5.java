package by.jonline.module1.iteration;

import static java.lang.Math.*;

/**
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
 * заданному е. Общий член ряда имеет вид:
 * an = 1/2^n + 1/3^n
 */
public class Task5 {

	public static void main(String[] args) {
		int n = 10;
		double e = 0.001;

		System.out.printf("Cyмма %d членов ряда = %.4f",n, sum(n, e));
	}

	public static double sum(int count, double e) {
		double sum = 0;

		for (int i = 1; i <= count; i++) {
			double an = (double) 1 / pow(2, i) + (double) 1 / pow(3, i);
			if (abs(an) >= e) {
				sum += an;
			}
		}
		return sum;
	}
}
