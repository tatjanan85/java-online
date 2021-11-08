package by.jonline.module3.part1.string;

/**
 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */
public class Task1 {

	public static void main(String[] args) {
		String str = "Дан текст  (строка). Найдите  наибольшее количество подряд идущих пробелов в нем.    ";
		System.out.println(str);

		int result = findMaxOfSpaces(str);
		System.out.println("Максимальное количество подряд идущих пробелов = " + result);
	}

	public static int findMaxOfSpaces(String str) {
		int count = 0;
		int max = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			} else if (count > 0) {
				if (count > max) {
					max = count;
				}
				count = 0;
			}
		}
		//если наибольшее количество пробелов стояло в конце строки
		if (count > max) {
			return count;
		}
		return max;
	}
}
