package by.jonline.module2.matrix;

import static by.jonline.module2.matrix.MatrixCreator.createMatrix;
import static by.jonline.module2.matrix.MatrixCreator.printMatrix;

/**
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
public class Task2 {

	public static void main(String[] args) {

		int m = 4;

		int[][] matrix = createMatrix(m, m);
		printMatrix(matrix);

		printMainDiagonal(matrix);
		printNotMainDiagonal(matrix);
	}

	public  static void printMainDiagonal(int[][] array) {

		System.out.println("Элементы главной диагонали:");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][i] + " ");
		}
		System.out.println();
	}

	public  static void printNotMainDiagonal(int[][] array) {
		int j = 0;
		System.out.println("Элементы побочной диагонали:");

		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i][j++] + " ");
		}
		System.out.println();
	}
}
