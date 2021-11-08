package by.jonline.module3.part1.string_as_array;

/**
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */
public class Task1 {
	public static void main(String[] args) {
		String str = "camelCaseModifyPLEASE";

		System.out.println("До преобразования: " + str);
		System.out.println("После преобразования: " + findCamelCase(str.toCharArray()));
	}

	//поиск прописных символов
	public static String findCamelCase(char[] chars) {
		char[] alphabetUpper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
						   'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

		char[] alphabetLower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
						   'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < alphabetUpper.length; j++) {
				if (chars[i] == alphabetUpper[j]) {
					chars = modifyToSnakeCase(chars, i, alphabetLower[j]);
				}
			}
		}
		return new String(chars);
	}

	public static char[] modifyToSnakeCase(char[] chars, int pos, char symbol) {
		char[] snakeCaseChars = new char[chars.length + 1];

		System.arraycopy(chars, 0, snakeCaseChars, 0, pos);
		System.arraycopy(chars, pos, snakeCaseChars, pos + 1, chars.length - pos);

		snakeCaseChars[pos] = '_';
		snakeCaseChars[pos + 1] = symbol;

		return snakeCaseChars;
	}
}
