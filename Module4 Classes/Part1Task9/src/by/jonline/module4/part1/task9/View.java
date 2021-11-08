package by.jonline.module4.part1.task9;

import java.util.List;

public class View {
	BookLogic logic = new BookLogic();

	public void printAllBooks(List<Book> books) {
		if (books.size() > 0) {
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i));
			}
		} else {
			System.out.println("Данные не найдены");
		}
	}

	public void printBooksByAuthor(List<Book> books, String author) {
		List<Book> result = logic.findBooksByAuthor(books, author);

		System.out.println("Книги автора " + author + ":");
		printAllBooks(result);

		System.out.println("---------------------");
	}

	public void printBooksByPublishing(List<Book> books, String publishing) {
		List<Book> result = logic.findBooksByPublishing(books, publishing);

		System.out.println("Книги издательства " + publishing + ":");
		printAllBooks(result);

		System.out.println("---------------------");
	}

	public void printPublishingAfterYear(List<Book> books, int year) {
		List<Book> result = logic.findBooksPublishingAfterYear(books, year);

		System.out.println("Книги, выпущенные после " + year + "  г. включительно:");
		printAllBooks(result);

		System.out.println("---------------------");
	}
}
