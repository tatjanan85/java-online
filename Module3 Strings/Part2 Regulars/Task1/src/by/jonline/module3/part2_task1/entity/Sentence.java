package by.jonline.module3.part2_task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {

	private String content;

	public Sentence(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public List<Word> getWords() {
		Pattern pattern = Pattern.compile("([a-zA-Z0-9а-яА-Я-]+?)([\\p{Punct}\\s])");
		Matcher matcher = pattern.matcher(content);

		List<Word> list = new ArrayList<Word>();

		while (matcher.find()) {
			list.add(new Word(matcher.group(1)));
		}
		return list;
	}

}
