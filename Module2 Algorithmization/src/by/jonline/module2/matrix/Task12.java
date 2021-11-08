package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.createMatrix;
import static by.jonline.module2.matrix.MatrixCreator.printMatrix;

/**
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов
 */
public class Task12 {

	public static void main(String[] args) {

		int m = 5;
		int n = 5;

		int[][] matrix = createMatrix(m, n);
		printMatrix(matrix);

		sortElementsInRowsAsc(matrix);
		System.out.println("Сортировка по возрастанию элементов строк");
		printMatrix(matrix);

		sortElementsInRowsDesc(matrix);
		System.out.println("Сортировка по убыванию элементов строк");
		printMatrix(matrix);
	}

	public static void sortElementsInRowsAsc(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			sortElementsInRowAsc(matrix, i);
		}
	}

	public static void sortElementsInRowsDesc(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			sortElementsInRowDesc(matrix, i);
		}
	}

	//сортировка элементов в строках
	private static void sortElementsInRowAsc(int[][] matrix, int row) {
		for (int i = 0; i < matrix[row].length - 1; i++) {
			for (int j = 0; j < matrix[row].length - i - 1; j++) {
				if (matrix[row][j] > matrix[row][j + 1]) {
					int temp = matrix[row][j];
					matrix[row][j] = matrix[row][j + 1];
					matrix[row][j + 1] = temp;
				}
			}
		}
	}

	// сортировка элементов в row строке
	private static void sortElementsInRowDesc(int[][] matrix, int row) {
		for (int i = 0; i < matrix[row].length - 1; i++) {
			for (int j = 0; j < matrix[row].length - i - 1; j++) {
				if (matrix[row][j] < matrix[row][j + 1]) {
					int temp = matrix[row][j];
					matrix[row][j] = matrix[row][j + 1];
					matrix[row][j + 1] = temp;
				}
			}
		}
	}
}
