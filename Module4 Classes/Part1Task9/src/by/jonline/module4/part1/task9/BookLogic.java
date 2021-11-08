package by.jonline.module4.part1.task9;

import java.util.ArrayList;
import java.util.List;

public class BookLogic {

	public List<Book> findBooksByAuthor(List<Book> books, String author) {
		List<Book> result = new ArrayList<Book>();

		for (Book book : books) {
			List<String> authors = book.getAuthors();

			if (authors.contains(author)) {
				result.add(book);
			}
		}

		return result;
	}

	public List<Book> findBooksByPublishing(List<Book> books, String publishing) {
		List<Book> result = new ArrayList<Book>();

		for (Book book : books) {
			String pub = book.getPublishing();

			if (pub.equalsIgnoreCase(publishing)) {
				result.add(book);
			}
		}

		return result;
	}

	public List<Book> findBooksPublishingAfterYear(List<Book> books, int year) {
		List<Book> result = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getYear() >= year) {
				result.add(book);
			}
		}

		return result;
	}


}
