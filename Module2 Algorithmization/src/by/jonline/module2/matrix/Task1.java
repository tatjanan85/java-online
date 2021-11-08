package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.*;

/**
 *  Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего
 */
public class Task1 {
	public static void main(String[] args) {

		int m = 3;
		int n = 10;

		int[][] matrix = createMatrix(m, n);

		printMatrix(matrix);
		printColumns(matrix);
	}

	public static void printColumns(int[][] matrix) {
		int count = 0;

		for (int j = 0; j < matrix[0].length; j++) {
			if ((j % 2 != 0) && (matrix[0][j] > matrix[matrix.length - 1][j])) {
				System.out.println("\nСтолбец с индексом " + j + ": ");
				count++;

				for (int i = 0; i < matrix.length; i++) {
					System.out.print(matrix[i][j] + " ");
				}
			}
		}

		if (count == 0) {
			System.out.println("\nНет нечетных 2столбцов, в которых 1-й элемент больше последнего");
		}
	}
}
