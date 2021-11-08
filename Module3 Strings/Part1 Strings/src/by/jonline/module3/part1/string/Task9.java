package by.jonline.module3.part1.string;

/**
 * Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
 * буквы.
 */
public class Task9 {

	public static void main(String[] args) {
		String str = "abczABCDZ";

		System.out.println("В строке:\n" + str);
		System.out.println(countLowers(str) + " строчных букв");
		System.out.println(countUppers(str) + " прописных букв");
	}

	//подсчёт прописных букв
	public static int countUppers(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			int code = str.codePointAt(i);

			if (code >= 65 && code <= 90) {
				count++;
			}
		}
		return count;
	}

	//подсчёт строчных букв
	public static int countLowers(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			int code = str.codePointAt(i);

			if (code >= 97 && code <= 122) {
				count++;
			}
		}
		return count;
	}
}
