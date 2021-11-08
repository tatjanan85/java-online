package by.jonline.module2.matrix;

import java.util.Random;

public class MatrixCreator {
	//создание матрицы размером m x n
	public static int[][] createMatrix(int m, int n) {
		int[][] array = new int[m][n];
		Random random = new Random();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = random.nextInt(100);
			}
		}
		return array;
	}

	//создание матрицы размером m x n
	public static int[][] createPosNegMatrix(int m, int n) {
		int[][] array = new int[m][n];
		Random random = new Random();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = random.nextInt(200) - 100;
			}
		}
		return array;
	}

	//печать матрицы
	public static void printMatrix(int[][] array) {
		System.out.print("Элементы массива: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println();
			for (int j = 0; j < array[i].length; j++)
				System.out.printf("%3d ", array[i][j]);
		}
		System.out.println();
	}

	public static void printMatrix(double[][] array) {
		System.out.print("Элементы массива: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println();
			for (int j = 0; j < array[i].length; j++)
				System.out.printf("%7.2f ", array[i][j]);
		}
		System.out.println();
	}
}
