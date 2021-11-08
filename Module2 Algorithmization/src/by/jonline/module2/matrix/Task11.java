package by.jonline.module2.matrix;

import java.util.Random;

/**
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
 * которых число 5 встречается три и более раз.
 */
public class Task11 {

	public static void main(String[] args) {
		int[][] matrix = createMatrix(10, 20, 5);
		MatrixCreator.printMatrix(matrix);

		printRow(matrix, 5, 3);
	}

	public static int[][] createMatrix(int m, int n, int limit) {

		int[][] array = new int[m][n];
		Random random = new Random();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = random.nextInt(15 + 1);
			}
		}
		return array;
	}

	public static void printRow(int[][] matrix, int value, int repetition) {
		boolean rowsNotFound = true;

		System.out.println("Индексы строк, которые содержат число '" +
				value + "' " + repetition + " и более раз: ");

		for (int i = 0; i < matrix.length; i++) {
			int count = 0;

			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == value) {
					count++;
				}
			}

			if (count >= repetition) {
				System.out.print(i + " ");
				rowsNotFound = false;
			}
		}

		if (rowsNotFound) {
			System.out.println("таких строк не найдено");
		}
	}
}
