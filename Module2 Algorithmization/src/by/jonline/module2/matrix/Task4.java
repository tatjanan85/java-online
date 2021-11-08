package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.printMatrix;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 	1	2	3	...	 n
 * 	n  n-1 n-2	...	 1
 * 	1	2	3	...	 n
 * 	n  n-1 n-2	...	 1
 * 	..  ..  ..  ...  ..
 * 	n  n-1 n-2	...	 1
 */
public class Task4 {
	public static void main(String[] args) {
		int n = 4;

		int[][] matrix = createMatrix(n);
		printMatrix(matrix);
	}

	public static int[][] createMatrix(int n) {
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {
					matrix[i][j] = j + 1;
				} else {
					matrix[i][j] = n - j;
				}
			}
		}
		return matrix;
	}
}
