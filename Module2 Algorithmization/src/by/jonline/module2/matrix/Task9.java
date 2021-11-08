package by.jonline.module2.matrix;

/**
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */
public class Task9 {
	public static void main(String[] args) {

		int m = 5;
		int n = 5;

		int[][] matrix = MatrixCreator.createMatrix(m, n);
		MatrixCreator.printMatrix(matrix);

		System.out.println("Индекс столбца с максимальной суммой элементов = " + maxColumnSum(matrix));
	}

	public static int columnSum(int[][] matrix, int column) {
		int sum = 0;

		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][column];
		}
		return sum;
	}

	public static int maxColumnSum(int[][] matrix) {
		int maxSum = 0;
		int index = -1;

		for (int j = 0; j < matrix[0].length; j++) {
			int sum = columnSum(matrix, j);
			System.out.println("Cтолбец с индексом " + j + " сумма = " + sum);

			if (sum > maxSum) {
				maxSum = sum;
				index = j;
			}
		}
		return index;
	}
}
