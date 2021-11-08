package by.jonline.module3.part1.string;

/**
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 * знаком. Определить количество предложений в строке X.
 */
public class Task10 {

	public static void main(String[] args) {
		String x = "Ааааа!!!! Они забили гол! Очень динамичная игра.";

		System.out.println("В тексте:\n" + x);
		System.out.println(countSentences(x) + " предложений");
	}

	public static int countSentences(String str) {
		String[] sentences = str.split("[.?!]");
		int count = 0;

		for (int i = 0; i < sentences.length; i++) {
			if (sentences[i].length() > 0) {
				count++;
			}
		}
		return count;
	}
}
