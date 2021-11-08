package by.jonline.module1.condition;

import java.util.Scanner;

/**
 * Найти max{min(a, b), min(c, d)}
 */
public class Task2 {

	public static void main(String[] args) {
		int a, b, c, d;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Введите значение a:");
		while (!sc.hasNextInt()) {
			System.out.println("Введите значение a:");
			sc.next();
		}
		a = sc.nextInt();

		System.out.println("Введите значение b:");
		while (!sc.hasNextInt()) {
			System.out.println("Введите значение b:");
			sc.next();
		}
		b = sc.nextInt();

		System.out.println("Введите значение c:");
		while (!sc.hasNextInt()) {
			System.out.println("Введите значение c:");
			sc.next();
		}
		c = sc.nextInt();

		System.out.println("Введите значение d:");
		while (!sc.hasNextInt()) {
			System.out.println("Введите значение d:");
			sc.next();
		}
		d = sc.nextInt();

		int max = max(min(a, b), min(c, d));

		System.out.printf("max{ min(%d, %d), min(%d, %d) } = %d", a, b, c, d, max);
	}

	public static int max(int value1, int value2) {
		return value1 > value2 ? value1 : value2;
	}

	public static int min(int value1, int value2) {
		return value1 < value2 ? value1 : value2;
	}
}
