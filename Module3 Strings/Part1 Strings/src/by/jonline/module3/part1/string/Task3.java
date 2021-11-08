package by.jonline.module3.part1.string;

/**
 * Проверить, является ли заданное слово палиндромом
 */
public class Task3 {
	public static void main(String[] args) {
		String str = "3026203";

		System.out.println("Слово " + str + " палиндром? - " + isPalindrom(str));
	}

	public static String isPalindrom(String str) {
		return str.contentEquals(new StringBuilder(str).reverse()) ? "да" : "нет";
	}
}
