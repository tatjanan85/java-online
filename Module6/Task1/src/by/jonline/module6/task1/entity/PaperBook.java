package by.jonline.module6.task1.entity;

import java.util.Objects;

public class PaperBook extends Book {
	private Cover cover;

	public PaperBook(String title, String author, int pages, String publisher, int year) {
		super(title, author, pages, publisher, year);
	}

	public enum Cover {
		HARD("твёрдый"), SOFT("мягкий");

		private String name;

		Cover(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PaperBook paperBook = (PaperBook) o;
		return cover == paperBook.cover;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cover, super.hashCode());
	}

	@Override
	public String toString() {
		return "Книга [" +
				"название = \"" + getTitle() + "\"" +
				", автор = " + getAuthor() +
				", страниц = " + getPages() +
				", издательство = " + getPublisher() +
				", год издания = " + getYear() +
				", переплёт = " + cover +
				"]";
	}
}
