package by.jonline.module3.part2_task1.logic;

import by.jonline.module3.part2_task1.entity.Paragraph;
import by.jonline.module3.part2_task1.entity.Sentence;

import java.util.List;

public class ParagraphLogic {

	private SentenceLogic sLogic = new SentenceLogic();

	public String getContentSortedByWordLength(Paragraph paragraph) {
		String result = "";
		List<Sentence> sentences = paragraph.getSentences();

		for (int i = 0; i < sentences.size(); i++) {
			result += "Предложение " + (i + 1) + " :\n\t" +
					sLogic.getContentSortedByWordsLength(sentences.get(i)) + "\n";
		}

		return result;
	}

	public String getContentSortedBySymbolInWords(Paragraph paragraph, char symbol) {
		String result = "";
		List<Sentence> sentences = paragraph.getSentences();

		for (int i = 0; i < sentences.size(); i++) {
			result += "Предложение " + (i + 1) + " :\n\t" +
					sLogic.getContentSortedBySymbolInWords(sentences.get(i), symbol) + "\n";
		}
		return result;
	}
}
