package by.jonline.module2.matrix;

import java.util.Random;

/**
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы
 */
public class Task3 {

	public static void main(String[] args) {

		int m = 5;
		int n = 5;

		int[][] matrix = MatrixCreator.createMatrix(m, n);
		MatrixCreator.printMatrix(matrix);

		Random random = new Random();
		printRow(matrix, random.nextInt(m));
		printColumn(matrix, random.nextInt(n));
	}

	public static void printColumn(int[][] array, int column) {
		System.out.println("\nВывод элементов столбца с индексом " + column);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][column] + " ");
		}
	}

	public static void printRow(int[][] array, int row) {
		System.out.println("\nВывод элементов строки с индексом " + row);

		for (int j = 0; j < array[0].length; j++) {
			System.out.print(array[row][j] + " ");
		}
	}
}
