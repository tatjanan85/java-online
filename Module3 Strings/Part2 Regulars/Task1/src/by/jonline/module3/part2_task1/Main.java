package by.jonline.module3.part2_task1;

import by.jonline.module3.part2_task1.entity.Text;
import by.jonline.module3.part2_task1.logic.TextLogic;

/**
 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
 * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
 * алфавиту.
 */
public class Main {

	public static void main(String[] args) {
		String content = "Эта глава о том, как начать работу с Git. Вначале изучим основы систем контроля версий, " +
						"затем перейдём к тому, как запустить Git на вашей ОС и окончательно настроить для работы.\n" +
						"B конце главы вы уже будете знать, что такое Git и почему им следует пользоваться, " +
						"а также получите окончательно настроенную для работы систему.\n";

		Text text= new Text(content);
		TextLogic textLogic = new TextLogic();

		System.out.println(textLogic.getTextParagraphsSortedBySentences(text));
		System.out.println(textLogic.getContentWordsSortedByLength(text));
		System.out.println(textLogic.getContentWordsSortedBySymbol(text, 'т'));
	}
}
