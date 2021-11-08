package by.jonline.module3.part2_task1.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {

	private String content;

	public Word(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public int countSymbol(char symbol) {
		Pattern pattern = Pattern.compile(Character.toString(symbol) + "{1}");
		Matcher matcher = pattern.matcher(content);
		int count = 0;

		while(matcher.find()) {
			count++;
		}

		return count;
	}

}
