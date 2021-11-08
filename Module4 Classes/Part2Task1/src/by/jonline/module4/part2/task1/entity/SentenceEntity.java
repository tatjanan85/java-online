package by.jonline.module4.part2.task1.entity;

public class SentenceEntity {
	private String content;

	public SentenceEntity(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return content;
	}
}
