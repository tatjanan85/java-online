package by.jonline.module3.part1.string_as_array;

/**
 * В строке найти количество чисел
 */
public class Task4 {

	public static void main(String[] args) {
		String str = "14 авг. 2018 г.";

		int result = countNumbers(str.toCharArray());
		System.out.println("Количество чисел = " + result);
	}

	public static int countNumbers(char[] chars) {
		char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int count = 0;
		boolean isPreviousNumber = false;

		for (int i = 0; i < chars.length; i++) {
			boolean isCurrentNumber = false;

			for (int j = 0; j < digits.length; j++) {
				if (chars[i] == digits[j]) {
					isCurrentNumber = true;
					break;
				}
			}

			//если текущий символ - число, то смотрим, не является ли он последним в строке
			//если текущий символ - не число, но предудущий - число, то увеличиваем счётчик чисел
			if (isCurrentNumber) {
				if (i == chars.length - 1) {
					count++;
				} else {
					isPreviousNumber = true;
				}
			} else if (isPreviousNumber) {
				count++;
				isPreviousNumber = false;
			}
		}
		return count;
	}
}
