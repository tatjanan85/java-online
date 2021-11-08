package by.jonline.module4.part2.task1;

import by.jonline.module4.part2.task1.entity.PunctuationMark;
import by.jonline.module4.part2.task1.entity.Sentence;
import by.jonline.module4.part2.task1.entity.Text;
import by.jonline.module4.part2.task1.entity.Word;
import by.jonline.module4.part2.task1.view.View;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
 * консоль текст, заголовок текста.
 */
public class Main {

	public static void main(String[] args) {

		Text text = new Text();
		Sentence title = new Sentence();
		title.addWord(new Word("Задание"));
		text.setTitle(title);

		Sentence sentense1 = new Sentence();
		sentense1.addWord(new Word("Создать"));
		sentense1.addWord(new Word("объект"));
		sentense1.addWord(new Word("класса"));
		sentense1.addWord(new Word("Текст"));
		sentense1.addPunctuationMark(new PunctuationMark(","));
		sentense1.addWord(new Word("используя"));
		sentense1.addWord(new Word("классы"));
		sentense1.addWord(new Word("Предложение"));
		sentense1.addPunctuationMark(new PunctuationMark(","));
		sentense1.addWord(new Word("Слово"));
		sentense1.addPunctuationMark(new PunctuationMark("."));

		//дополнение текста новым предложением
		text.addSentence(sentense1);

		//вывод текста и заголовка на консоль
		View view = new View();
		view.printText(text);
		view.printTextTitle(text);
	}
}
