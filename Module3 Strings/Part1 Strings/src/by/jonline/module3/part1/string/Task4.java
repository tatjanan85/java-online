package by.jonline.module3.part1.string;

/**
 * С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */
public class Task4 {

	public static void main(String[] args) {
		String informatics = "информатика";
		String cake = "торт";

		//с помощью static String copyValueOf (char[] data, int offset, int count)
		System.out.println(copyValueOf(informatics));

		//своя функция копирования
		System.out.println(findAndCopy(informatics, cake));
	}

	public static String copyValueOf(String str) {
		String firstLetter, secondLetter, thirdLetter;
		char[] chars = str.toCharArray();

		firstLetter = String.copyValueOf(chars, 7, 1);
		secondLetter = String.copyValueOf(chars, 3, 1);
		thirdLetter = String.copyValueOf(chars, 4, 1);

		return  firstLetter + secondLetter + thirdLetter + firstLetter;
	}

	public static String findAndCopy(String str1, String str2) {
		char[] result = new char[str2.length()];
		int k = 0;

		for (int i = 0; i < str2.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				if (str2.charAt(i) == str1.charAt(j)) {
					result[k++] = str1.charAt(j);
				}
			}
		}
		return new String(result);
	}
}
