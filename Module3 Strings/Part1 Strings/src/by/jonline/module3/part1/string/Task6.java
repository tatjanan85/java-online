package by.jonline.module3.part1.string;

/**
 * Из заданной строки получить новую, повторив каждый символ дважды
 */
public class Task6 {

	public static void main(String[] args) {
		String str = "Из заданной строки получить новую, повторив каждый символ дважды";

		System.out.println(makeDoubleEveryLetter(str));
	}

	public static String makeDoubleEveryLetter(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			sb.insert(i, sb.charAt(i));
			i++;
		}
		return sb.toString();
	}
}
