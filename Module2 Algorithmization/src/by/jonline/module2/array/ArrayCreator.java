package by.jonline.module2.array;

import java.util.Random;

public class ArrayCreator {

	// генерация массива случайных натуральных чисел 1..100
	public static int[] createPositiveArray(int length) {
		int[] array = new int[length];
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			array[i] = random.nextInt(100);
		}
		return array;
	}


	// генерация массива целых отрицательных/положительных чисел -100..100
	public static int[] createPosNegArray(int length) {
		int[] array = new int[length];
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			array[i] = random.nextInt(200) - 100;
		}
		return array;
	}

	// генерация массива вещественных отрицательных/положительных чисел -100..100
	public static double[] createRealArray(int length) {
		double[] array = new double[length];
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			array[i] = (double) Math.round(random.nextDouble() * 100) / 100 + (random.nextInt(200) - 100);
		}
		return array;
	}

}
