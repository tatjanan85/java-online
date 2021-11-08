package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.printMatrix;
import static java.lang.Math.*;

/**
 * Сформировать квадратную матрицу порядка N по правилу:
 * A[I,J] = sin((I^2 - J^2) / N)
 * и подсчитать количество положительных элементов в ней.
 */
public class Task7 {
	public static void main(String[] args) {

		int n = 4;

		double[][] matrix = createMatrix(n);
		printMatrix(matrix);

		System.out.println("Количество положительных элементов = " + countPositive(matrix));
	}

	public static double[][] createMatrix(int n) {
		double[][] matrix = new double[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (double) round(sin((double)(i * i - j * j) / n) * 1000) / 1000;
			}
		}
		return matrix;
	}

	public static int countPositive(double[][] matrix) {
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > 0) {
					count++;
				}
			}
		}
		return count;
	}
}
