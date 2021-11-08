package by.jonline.module3.part2_task1.entity;

import by.jonline.module3.part2_task1.logic.ParagraphLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

	private String content;

	public Text(String content) {
		this.content = content;
	}

	public void setText(String content) {
		this.content = content;
	}

	public List<Paragraph> getParagraphs() {
		Pattern pattern = Pattern.compile("(.+?)(\n)");
		Matcher matcher = pattern.matcher(content);
		List<Paragraph> list = new ArrayList<Paragraph>();

		while (matcher.find()) {
			list.add(new Paragraph(matcher.group(1)));
		}
		return list;
	}


}

