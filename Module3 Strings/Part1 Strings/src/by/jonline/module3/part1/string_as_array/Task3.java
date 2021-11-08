package by.jonline.module3.part1.string_as_array;

/**
 * В строке найти количество цифр.
 */
public class Task3 {

	public static void main(String[] args) {
		String str = "Витебск ул.1-я Доватора 2";

		int result = countDigits(str.toCharArray());
		System.out.println("Количество цифр = " + result);
	}

	public static int countDigits(char[] chars) {
		char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int count = 0;

		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < digits.length; j++) {
				if (chars[i] == digits[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
