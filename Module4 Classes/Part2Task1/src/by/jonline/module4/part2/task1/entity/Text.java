package by.jonline.module4.part2.task1.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {

	private Sentence title;
	private List<Sentence> sentences = new ArrayList<Sentence>();

	public Text() {
	}

	public Sentence getTitle() {
		return title;
	}

	public void setTitle(Sentence title) {
		this.title = title;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void addSentence(Sentence sentence) {
		sentences.add(sentence);
	}


}
