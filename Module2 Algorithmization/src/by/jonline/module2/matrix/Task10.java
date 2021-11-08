package by.jonline.module2.matrix;

/**
 * Найти положительные элементы главной диагонали квадратной матрицы
 */
public class Task10 {

	public static void main(String[] args) {

		int m = 5;

		int[][] matrix = MatrixCreator.createPosNegMatrix(m, m);
		MatrixCreator.printMatrix(matrix);

		printPositive(matrix);
	}

	public static void printPositive(int[][] matrix) {
		int count = 0;

		System.out.println("Положительные элементы главной диагонали:");
		for (int i = 1; i < matrix.length ; i++) {
			int element = matrix[i][i];
			if (element > 0) {
				System.out.print(element + " ");
				count++;
			}
		}

		if (count == 0) {
			System.out.println("нет положительных элементов");
		}
	}

}
