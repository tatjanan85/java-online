package by.jonline.module3.part1.string_as_array;

/**
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */
public class Task5 {

	public static void main(String[] args) {
		String str = "    Удалить  в строке  все    лишние пробелы   ";

		System.out.println("До преобразования: \n" + "начало строки |" + str + "| конец строки");

		String newStr = deleteExtraSpaces(str.toCharArray());
		System.out.println("После преобразования: \n"  + "начало строки |" + newStr + "| конец строки");
	}

	public static String deleteExtraSpaces(char[] chars) {
		int count = 0;
		boolean isPreviousSpace = false;

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				//если предыдущий символ - пробел, или текущий 0-й символ - пробел, то удалить лишний
				if (isPreviousSpace || i == 0) {
					chars = moveChars(chars, i);
					i--;
				} else {
					isPreviousSpace = true;
				}
			} else {
				isPreviousSpace = false;
			}

		}
		//если последний символ пробел - удалить
		if (chars[chars.length - 1] == ' ') {
			chars = moveChars(chars, chars.length - 1);
		}

		return new String(chars);
	}

	public static char[] moveChars(char[] chars, int pos) {
		char[] newArray = new char[chars.length - 1];
		System.arraycopy(chars, 0, newArray, 0, pos);

		if (chars.length - 1 >= pos) {
			System.arraycopy(chars, pos + 1, newArray, pos, chars.length - 1 - pos);
		}
		return newArray;
	}
}
