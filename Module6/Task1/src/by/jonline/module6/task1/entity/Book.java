package by.jonline.module6.task1.entity;

import java.util.Objects;

public abstract class Book {
	private int id;
	private String author;
	private String title;
	private int pages;
	private String publisher;
	private int year;

	public Book(String title, String author, int pages, String publisher, int year) {
		this.author = author;
		this.title = title;
		this.pages = pages;
		this.publisher = publisher;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		Book book = (Book) o;
		return id == book.id && pages == book.pages && year == book.year
				&& Objects.equals(author, book.author) && Objects.equals(title, book.title)
				&& Objects.equals(publisher, book.publisher);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, author, title, pages, publisher, year);
	}
}
