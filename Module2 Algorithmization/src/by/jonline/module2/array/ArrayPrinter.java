package by.jonline.module2.array;

public class ArrayPrinter {

	public static void printArray(int[] array) {
		System.out.println("Элементы массива: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public static void printArray(double[] array) {
		System.out.println("Элементы массива: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
