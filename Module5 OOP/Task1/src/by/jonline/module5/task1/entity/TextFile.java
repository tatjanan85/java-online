package by.jonline.module5.task1.entity;

import java.util.Objects;

public class TextFile extends File {

	private String content;

	public TextFile(String name) {
		super(name);
	}

	public TextFile(String name, String content) {
		super(name);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addContent(String content) {
		this.content += "\n" + content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TextFile)) return false;
		if (!super.equals(o)) return false;
		TextFile textFile = (TextFile) o;
		return Objects.equals(content, textFile.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), content);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"name=" + getName() + " " +
				"content=" + content +
				"}";
	}
}
