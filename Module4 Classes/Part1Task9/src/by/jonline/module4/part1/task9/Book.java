package by.jonline.module4.part1.task9;

import java.util.List;
import java.util.Objects;

public class Book {

	private int id;
	private String title;
	private List<String> authors;
	private String publishing;
	private int year;
	private int pages;
	private int price;
	private String binding;

	public Book() {
	}

	public Book(int id, String title, List<String> authors, int year, int pages) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		Book book = (Book) o;
		return id == book.id && year == book.year && pages == book.pages && price == book.price &&
				Objects.equals(title, book.title) &&
				Objects.equals(authors, book.authors) &&
				Objects.equals(publishing, book.publishing) &&
				Objects.equals(binding, book.binding);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, authors, publishing, year, pages, price, binding);
	}

	@Override
	public String toString() {
		return "Книга {" +
				"id=" + id +
				", название='" + title + '\'' +
				", авторы=" + authors +
				", издательство='" + publishing + '\'' +
				", год издания=" + year +
				", страниц=" + pages +
				", цена=" + price +
				", переплёт='" + binding + '\'' +
				'}';
	}
}
