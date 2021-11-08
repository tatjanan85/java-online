package by.jonline.module2.sorting;

import java.util.Random;
import java.util.Scanner;

/**
 * Даны дроби
 * p₁/q₁, p₂/q₂, ... pn/qn
 * ( pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему
 * знаменателю и упорядочивает их в порядке возрастания.
 */
public class Task8 {

	public static void main(String[] args) {
		int[][] fractions = createFractions(5);

		int denominator = findDenominatorNOK(fractions);
		System.out.println("Общий знаменатель = " + denominator);

		System.out.println("Дроби до сортировки:");
		printFractions(fractions);

		sort(fractions, denominator);
		System.out.println("Дроби после сортировки:");
		printFractions(fractions);
	}

	public static void printFractions(int[][] fractions) {
		for (int i = 0; i < fractions.length; i++) {
			System.out.print(fractions[i][0] + "/" + fractions[i][1] + " ");
		}
		System.out.println();
	}

	public static void sort(int[][] array, int denominator) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				int numerator1 = array[j][0] * (denominator / array[j][1]);
				int numerator2 = array[j + 1][0] * (denominator / array[j + 1][1]);

				if (numerator1 > numerator2) {
					int tempNum = array[j][0];
					int tempDen = array[j][1];
					array[j][0] = array[j + 1][0];
					array[j][1] = array[j + 1][1];
					array[j + 1][0] = tempNum;
					array[j + 1][1] = tempDen;
				}
			}
		}
	}

	public static int[][] createFractions(int n) {

		Random random = new Random();
		int[][] fractions = new int[n][2];

		for (int i = 0; i < n; i++) {
			fractions[i][0] = random.nextInt(10) + 1;
			fractions[i][1] = random.nextInt(10) + 1;
		}

		return fractions;
	}

	public static int findDenominatorNOK(int[][] fractions) {
		int nok = fractions[0][1];

		for (int i = 1; i < fractions.length; i++) {
			nok = findNOK(nok, fractions[i][1]);
		}
		return nok;
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
