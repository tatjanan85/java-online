package by.jonline.module2.matrix;

import java.util.Random;

/**
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца.
 */
public class Task14 {

	public static void main(String[] args) {

		int m = 5;
		int n = 5;

		int[][] matrix = createMatrix(m, n);
		MatrixCreator.printMatrix(matrix);
	}

	// заполняем только единицы, нули стоят по умолчанию
	public static int[][] createMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		Random random = new Random();

		for (int j = 0; j < n; j++) {
			int count = j;

			for (int k = 0; k < count; k++) {
				//случайная строка, в которую занесётся единица
				int row = random.nextInt(m);

				//если в данной строке уже стоит единица, то увеличиваем верхний порог цикла
				if (matrix[row][j] != 1) {
					matrix[row][j] = 1;
				} else {
					count++;
				}
			}
		}

		return matrix;
	}
}
