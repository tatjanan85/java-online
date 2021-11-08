package by.jonline.module2.matrix;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 		1    1    1  ...  1    1    1
 * 	    2    2    2  ...  2    2    0
 * 	    3    3    3  ...  3    0    0
 * 	    ..   ..   .. ...  ..   ..   ..
 * 	   n-1  n-1   0  ...  0    0    0
 * 	    n    0    0  ...  0    0    0
  */
public class Task5 {

	public static void main(String[] args) {

		int n = 4;

		int[][] matrix = createMatrix(n);
		MatrixCreator.printMatrix(matrix);
	}

	public static int[][] createMatrix(int n) {
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j >= n) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = i + 1;
				}
			}
		}
		return matrix;
	}
}
