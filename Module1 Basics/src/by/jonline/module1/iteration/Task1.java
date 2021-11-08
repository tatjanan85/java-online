package by.jonline.module1.iteration;

import java.util.Scanner;

/**
 * Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
 * все числа от 1 до введенного пользователем числа.
 */
public class Task1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int value;
		do {
			System.out.println("Введите целое положительное число:");

			while (!sc.hasNextInt()) {
				System.out.println("Введите целое положительное число:");
				sc.next();
			}

			value = sc.nextInt();

		} while (value <= 0);

		System.out.printf("Сумма чисел от 1 до %d = %d", value, sum(value));
	}

	public static int sum(int value) {
		int sum = 0;

		for (int i = 1; i <= value; i++) {
			sum += i;
		}

		return sum;
	}
}
