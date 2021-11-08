package by.jonline.module3.part2_task1.logic;

import by.jonline.module3.part2_task1.entity.Sentence;
import by.jonline.module3.part2_task1.entity.Word;

import java.util.List;

public class SentenceLogic {

	//  все слова предложения отсортированы по длине
	public String getContentSortedByWordsLength(Sentence sentence) {
		List<Word> list = sentence.getWords();
		int max = 0;
		String result = "";

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				String curWord = list.get(j).getContent();
				String nextWord = list.get(j + 1).getContent();

				if (curWord.length() > nextWord.length()) {
					Word word = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, word);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			result += list.get(i).getContent() + " ";
		}

		return result.substring(0, result.length() - 1);
	}

	// все слова предложения осортированы по количеству вхождения символа и в случае равенства по алфавиту
	public String getContentSortedBySymbolInWords(Sentence sentence, char symbol) {
		List<Word> list = sentence.getWords();
		int max = 0;
		String result = "";

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				Word curWord = list.get(j);
				Word nextWord = list.get(j + 1);

				if (curWord.countSymbol(symbol) < nextWord.countSymbol(symbol)) {
					Word word = curWord;
					list.set(j, nextWord);
					list.set(j + 1, word);
				} else if (curWord.countSymbol(symbol) == nextWord.countSymbol(symbol)) {
					if (curWord.getContent().compareToIgnoreCase(nextWord.getContent()) > 0) {
						Word word = curWord;
						list.set(j, nextWord);
						list.set(j + 1, word);
					}
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			result += list.get(i).getContent() + " ";
		}

		return result.substring(0, result.length() - 1);
	}
}
