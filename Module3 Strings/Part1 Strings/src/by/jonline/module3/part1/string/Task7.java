package by.jonline.module3.part1.string;

/**
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 * def", то должно быть выведено "abcdef".
 */
public class Task7 {

	public static void main(String[] args) {
		String str = "abc cde def";
		System.out.println(str);

		String result;
		result = deleteExtraSymbols(str);
		result = deleteAllSpaces(result);

		System.out.println(result);
	}

	public static String deleteExtraSymbols(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length() - 1; i++) {
			for (int j = i + 1; j < sb.length(); j++) {
				if (sb.charAt(i) == sb.charAt(j)) {
					sb.deleteCharAt(j--);
				}
			}
		}
		return sb.toString();
	}

	public static String deleteAllSpaces(String str) {
		return str.replaceAll(" ", "");
	}

}
