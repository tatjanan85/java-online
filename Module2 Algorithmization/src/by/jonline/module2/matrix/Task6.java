package by.jonline.module2.matrix;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 		1	1	1	..	1	1	1
 * 		0	1	1	..	1	1	0
 * 		0	0	1	..	1	0	0
 * 		..	..	..	..	..	..	..
 * 		0	1	1	..	1	1	0
 * 		1	1	1	..	1	1	1
 */
public class Task6 {

	public static void main(String[] args) {

		int n = 6;

		int[][] matrix = createMatrix(n);
		MatrixCreator.printMatrix(matrix);
	}

	public static int[][] createMatrix(int n) {
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//элемент находится ниже главной диагонали, но выше побочной
				if ((i + j >= n) && (i < j)) {
					matrix[i][j] = 0;
				//элемент находится ниже побочной диагонали, но выше главной
				} else if ((i + j < n - 1) && (i > j)) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = 1;
				}
			}
		}
		return matrix;
	}
}
