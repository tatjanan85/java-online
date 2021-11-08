package by.jonline.module3.part2_task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {

	private String content;

	public Paragraph(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public List<Sentence> getSentences() {
		Pattern pattern = Pattern.compile("(.+?)([.?!])");
		Matcher matcher = pattern.matcher(content);
		List<Sentence> list = new ArrayList<Sentence>();

		while (matcher.find()) {
			list.add(new Sentence(matcher.group(1) + matcher.group(2)));
		}
		return list;
	}

	public int countSentences() {
		List<Sentence> sentences = getSentences();
		int count = 0;

		for (int i = 0; i < sentences.size(); i++) {
			if (sentences.get(i).getContent().length() > 0) {
				count++;
			}
		}
		return count;
	}

}

