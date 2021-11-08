package by.jonline.module3.part1.string;

/**
 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 * длинных слов может быть несколько, не обрабатывать.
 */
public class Task8 {

	public static void main(String[] args) {
		String str = "Найти самое длинное слово и вывести его на экран монитора";
		System.out.println(str);

		String longestWord = findLongestWord(str);

		if (longestWord != null) {
			System.out.println("Самое длинное слово - \"" + findLongestWord(str) + "\"");
		} else {
			System.out.println("В строке найдено несколько самых длинных слов");
		}
	}

	//возвращает null, если самых длинных слов несколько
	public static String findLongestWord(String str) {
		int start = 0;
		String maxWord = "";
		boolean doubleMax = false;
		int spacePosition = str.indexOf(" ", start);

		while (spacePosition >= 0) {
			int length = spacePosition - start;

			if (length > maxWord.length()) {
				maxWord = str.substring(start, spacePosition);
				doubleMax = false;
			} else if (length == maxWord.length()) {
				doubleMax = true;
			}

			start = spacePosition + 1;
			spacePosition = str.indexOf(" ", start);
		}

		//последнее слово, которое не найдено выше из-за того, что после него не стоит пробел
		String lastWord = str.substring(start, str.length());

		if (lastWord.length() > maxWord.length()) {
			maxWord = lastWord;
			doubleMax = false;
		} else if (lastWord.length() == maxWord.length()) {
			doubleMax = true;
		}

		return !doubleMax ? maxWord : null;
	}
}
