package by.jonline.module3.part2_task1.logic;

import by.jonline.module3.part2_task1.entity.Paragraph;
import by.jonline.module3.part2_task1.entity.Text;

import java.util.List;

public class TextLogic {

	private ParagraphLogic pLogic = new ParagraphLogic();

	public String getTextParagraphsSortedBySentences(Text text) {
		String result = "---- Абзацы отсортированы по количеству предложений: ----\n";
		List<Paragraph> list = text.getParagraphs();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				Paragraph curP = list.get(j);
				Paragraph nexP = list.get(j + 1);

				if (curP.countSentences() > nexP.countSentences()) {
					Paragraph temp = curP;
					list.set(j, nexP);
					list.set(j + 1, temp);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			result += list.get(i).getContent() + "\n";
		}

		return result.substring(0, result.length() - 1);
	}

	public String getContentWordsSortedByLength(Text text) {
		String result = "---- Слова в предложениях отсортированы по длине: ----\n";
		List<Paragraph> list = text.getParagraphs();

		for (int i = 0; i < list.size(); i++) {
			result += "Абзац " + (i + 1) + ":\n" + pLogic.getContentSortedByWordLength(list.get(i));
		}
		return result;
	}

	public String getContentWordsSortedBySymbol(Text text, char symbol) {
		String result = "---- Слова в предложениях отсортированы по убыванию вхождения символа \"" + symbol + "\": ----\n";
		List<Paragraph> list = text.getParagraphs();

		for (int i = 0; i < list.size(); i++) {
			result += "Абзац " + (i + 1) + ":\n" + pLogic.getContentSortedBySymbolInWords(list.get(i), symbol);
		}

		return result;
	}
}
