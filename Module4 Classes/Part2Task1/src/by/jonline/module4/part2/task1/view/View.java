package by.jonline.module4.part2.task1.view;

import by.jonline.module4.part2.task1.entity.Sentence;
import by.jonline.module4.part2.task1.entity.Text;

public class View {

	public void printText(Text text) {
		System.out.println("---------------------");

		System.out.println("Содержание текста:");
		for (Sentence sentence : text.getSentences()) {
			System.out.print(sentence + " ");
		}
		
		System.out.println("\n---------------------");
	}

	public void printTextTitle(Text text) {
		System.out.println("Заголовок текста: " + text.getTitle());
	}
}
