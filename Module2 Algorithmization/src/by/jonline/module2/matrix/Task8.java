package by.jonline.module2.matrix;

import java.util.Scanner;
import static by.jonline.module2.matrix.MatrixCreator.*;

/**
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */
public class Task8 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		//размерность массива захардкожена
		int m = 5;
		int n = 5;

		int[][] matrix = createMatrix(m, n);
		printMatrix(matrix);

		int column1,column2;


		do {
			System.out.println("Введите номера (не индекс) 1-го столбца, элементы которого нужно поменять местами:");

			while (!sc.hasNextInt()) {
				System.out.println("Введите номера (не индекс) 1-го столбца, элементы которого нужно поменять местами:");
				sc.next();
			}

			column1 = sc.nextInt();

		} while (column1 <= 0 || column1 > n);


		do {
			System.out.println("Введите номера (не индекс) 2-го столбца, элементы которого нужно поменять местами:");

			while (!sc.hasNextInt()) {
				System.out.println("Введите номера (не индекс) 2-го столбца, элементы которого нужно поменять местами:");
				sc.next();
			}

			column2 = sc.nextInt();

		} while (column2 <= 0 || column2 > n);


		//для обмена элементами уменьшаем номер на 1, чтобы получить индекс
		exchangeElements(matrix, column1 - 1, column2 - 1);
		printMatrix(matrix);
		sc.close();
	}


	public static void exchangeElements(int[][] matrix, int column1, int column2) {
		for (int i = 0; i < matrix.length; i++) {
			int temp = matrix[i][column1];
			matrix[i][column1] = matrix[i][column2];
			matrix[i][column2] = temp;
		}
	}
}
