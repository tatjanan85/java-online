package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.createMatrix;
import static by.jonline.module2.matrix.MatrixCreator.printMatrix;

/**
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */
public class Task15 {

	public static void main(String[] args) {

		int m = 4;
		int n = 4;

		int[][] matrix = createMatrix(m, n);
		printMatrix(matrix);

		int max = max(matrix);
		System.out.println("максимальный элемент = " + max);

		replaceOddElements(matrix, max);
		printMatrix(matrix);
	}

	public static int max(int[][] matrix) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
			}
		}
		return max;
	}

	public static void replaceOddElements(int[][] matrix, int value) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] % 2 != 0) {
					matrix[i][j] = value;
				}
			}
		}
	}
}
