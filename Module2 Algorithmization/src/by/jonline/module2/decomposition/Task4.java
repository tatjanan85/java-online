package by.jonline.module2.decomposition;

import static java.lang.Math.*;

/**
 * На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */
public class Task4 {

	public static void main(String[] args) {
		int[][] coordinates = {{1, 0}, {0, 0}, {5, 6}, {-10, 1}};
		double[] data = lengthArray(coordinates);

		printResults(data, coordinates);
	}


	public static void printResults(double[] maxData, int[][] coordinates) {
		System.out.printf("Максимальное расстояние = %6.2f между точками (%d, %d) (%d %d)",
				maxData[0], coordinates[(int) maxData[1]][0], coordinates[(int) maxData[1]][1],
				coordinates[(int) maxData[2]][0], coordinates[(int) maxData[2]][1]);
	}

	//расстояние между 2 точками
	private static double findLength(int x1, int y1, int x2, int y2) {
		return sqrt(pow(abs(x2 - x1), 2) + pow(abs(y2 - y1), 2));
	}

	//получение данных о максимальном расстоянии между точками
	public static double[] lengthArray(int[][] array) {
		double[] lenArray = new double[3];
		lenArray[0] = 0;

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int x1 = array[i][0];
				int y1 = array[i][1];
				int x2 = array[j][0];
				int y2 = array[j][1];
				double length = findLength(x1, y1, x2, y2);

				if (length > lenArray[0]) {
					lenArray[0] = length;
					lenArray[1] = i;
					lenArray[2] = j;
				}
			}
		}
		return lenArray;
	}
}
