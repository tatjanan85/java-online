package by.jonline.module3.part1.string_as_array;

/**
 * Замените в строке все вхождения 'word' на 'letter'.
 */
public class Task2 {

	public static void main(String[] args) {
		String str = "One word, two words";

		System.out.println("До преобразования: " + str);

		String newStr = findWordReplaceToLetter(str.toCharArray(), "word", "letter");
		System.out.println("После преобразования: "  + newStr);
	}

	public static String findWordReplaceToLetter(char[] chars, String str1, String str2) {
		char[] word = str1.toCharArray();
		char[] letter = str2.toCharArray();

		for (int i = 0; i < word.length; i++) {
			int pos = findWord(chars, word);
			if (pos != -1)
				chars = replaceToLetter(chars, pos, word, letter);
		}
		return new String(chars);
	}

	//находит позицию первого вхождения word, иначе возвращает -1
	public static int findWord(char[] chars, char[] word) {
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == word[0]) {
				int count = 1;

				for (int j = 1; j < word.length; j++) {
					if (chars[i + j] == word[j]) {
						count++;
					} else {
						break;
					}
				}

				if (count == word.length) {
					return i;
				}
			}
		}
		return -1;
	}

	//заменяет первое вхождение word на letter
	public static char[] replaceToLetter(char[] chars, int pos, char[] word, char[] letter) {
		char[] newArray = new char[chars.length + letter.length - word.length];

		System.arraycopy(chars, 0, newArray, 0, pos);
		System.arraycopy(letter, 0, newArray, pos, letter.length);

		//если word не в конце строки
		if (chars.length >= pos + word.length) {
			System.arraycopy(chars, pos + word.length, newArray,
					pos + letter.length, chars.length - pos - word.length);
		}

		return newArray;
	}
}
