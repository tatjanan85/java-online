package by.jonline.module4.part2.task1.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
	private List<SentenceEntity> entities = new ArrayList<SentenceEntity>();

	public List<SentenceEntity> getEntities() {
		return entities;
	}

	public void addWord(Word word) {
		entities.add(word);
	}

	public void addPunctuationMark(PunctuationMark mark) {
		entities.add(mark);
	}

	@Override
	public String toString() {
		String content = "";
		for (SentenceEntity entity : getEntities())
			if (entity instanceof Word)
				content += entity.getContent() + " ";
			else {
				content = content.substring(0, content.length() - 1);
				content += entity.getContent() + " ";
			}
		return content;
	}
}
