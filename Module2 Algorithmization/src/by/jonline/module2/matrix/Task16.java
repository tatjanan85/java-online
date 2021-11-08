package by.jonline.module2.matrix;

/**
 * Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3, ..., n²
 * так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
 * собой. Построить такой квадрат. Пример магического квадрата порядка 3:
 * <p>
 * 6 1 8
 * 7 5 3
 * 2 9 4
 */
public class Task16 {

	public static void main(String[] args) {
		printMagicSquares(4);
	}

	public static void printMagicSquares(int size) {

		int i, j, k;
		int n = size * size;
		int[] array = new int[n];

		// заполняем квадрат числами в порядке возрастания
		for (i = 0; i < n; i++) {
			array[i] = i + 1;
		}

		while (true) {

			// если квадрат магический - распечатать
			if (isMagic(array, size)) {
				printSquare(array, size);
			}

			//находим первое число, идущее не в порядке убывания
			for (j = n - 1; j > 0; j--) {
				if (array[j] > array[j - 1]) break;
			}

			if (j == 0) System.exit(0);

			j--;

			//делаем перестановку числа с предыдущего шага
			for (k = n - 1; k > j; k--) {
				if (array[k] > array[j]) {
					int temp = array[k];
					array[k] = array[j];
					array[j] = temp;
					break;
				}
			}

			//сортируем в порядке возрастания
			int first, last;
			for (first = j + 1, last = n - 1; first < last; first++, last--) {
				int temp = array[first];
				array[first] = array[last];
				array[last] = temp;
			}
		}
	}

	private static boolean isMagic(int[] array, int n) {

		int sum;
		int magicConst = n * (n * n + 1) / 2;

		// проверка сумм по строкам
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += array[n * i + j];
			}

			if (sum != magicConst) {
				return false;
			}
		}

		// проверка по столбцам
		for (int j = 0; j < n; j++) {
			sum = 0;
			for (int i = 0; i < n; i++) {
				sum += array[n * i + j];
			}

			if (sum != magicConst) {
				return false;
			}
		}

		// проверка главной диагонали
		sum = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			sum += array[n * i + j];
			j++;
		}

		if (sum != magicConst) {
			return false;
		}

		// проверка побочной диагонали
		sum = 0;
		j = 0;
		for (int i = n - 1; i >= 0; i--) {
			sum += array[n * i + j];
			j++;
		}

		if (sum != magicConst) {
			return false;
		}

		return true;
	}

	private static void printSquare(int[] array, int n) {
		for (int i = 0; i < array.length; i++) {
			if (i % n == 0) {
				System.out.println();
			}
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}
}


