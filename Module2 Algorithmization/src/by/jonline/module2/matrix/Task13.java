package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.createMatrix;
import static by.jonline.module2.matrix.MatrixCreator.printMatrix;

/**
 * Отсотрировать столбцы матрицы по возрастанию и убыванию значений элементов
 */
public class Task13 {

	public static void main(String[] args) {

		int m = 5;
		int n = 5;

		int[][] matrix = createMatrix(m, n);
		printMatrix(matrix);

		sortElementsInСolsAsc(matrix);
		System.out.println("Сортировка по возрастанию элементов столбцов");
		printMatrix(matrix);

		sortElementsInColsDesc(matrix);
		System.out.println("Сортировка по убыванию элементов столбцов");
		printMatrix(matrix);
	}

	public static void sortElementsInСolsAsc(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			sortElementsInColAsc(matrix, i);
		}
	}

	public static void sortElementsInColsDesc(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			sortElementsInColDesc(matrix, i);
		}
	}

	//сортировка элементов в столбцах
	private static void sortElementsInColAsc(int[][] matrix, int col) {
		for (int i = 0; i < matrix[col].length - 1; i++) {
			for (int j = 0; j < matrix[col].length - i - 1; j++) {
				if (matrix[j][col] > matrix[j + 1][col]) {
					int temp = matrix[j][col];
					matrix[j][col] = matrix[j + 1][col];
					matrix[j + 1][col] = temp;
				}
			}
		}
	}

	// сортировка элементов в сol столбце
	private static void sortElementsInColDesc(int[][] matrix, int col) {
		for (int i = 0; i < matrix[col].length - 1; i++) {
			for (int j = 0; j < matrix[col].length - i - 1; j++) {
				if (matrix[j][col] < matrix[j + 1][col]) {
					int temp = matrix[j][col];
					matrix[j][col] = matrix[j + 1][col];
					matrix[j + 1][col] = temp;
				}
			}
		}
	}
}
