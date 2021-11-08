package by.jonline.module6.task1.entity;

import java.util.Objects;

public class EBook extends Book {

	private String fileFormat;
	public EBook(String title, String author, int pages, String publisher, int year) {
		super(title, author, pages, publisher, year);
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		EBook eBook = (EBook) o;
		return Objects.equals(fileFormat, eBook.fileFormat);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), fileFormat);
	}

	@Override
	public String toString() {
		return "Электронная книга [" +
				"название = \"" + getTitle() + "\"" +
				", автор = " + getAuthor() +
				", страниц = " + getPages() +
				", издательство = " + getPublisher() +
				", год издания = " + getYear() +
				", формат файла = " + fileFormat +
				"]";
	}
}
