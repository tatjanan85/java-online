package by.jonline.module4.part1.task9;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать класс by.jonline.module4.part1.task9.Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа by.jonline.module4.part1.task9.Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * by.jonline.module4.part1.task9.Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */
public class Main {

	public static void main(String[] args) {
		Book book1 = new Book(1, "Робинзон Крузо", List.of("Дефо"), 2020, 256);
		book1.setPublishing("Эксмо");
		book1.setPrice(12);
		book1.setBinding("твёрдый");

		Book book2 = new Book(2, "Гроздья гнева", List.of("Стейнбек"), 2018, 608);
		book2.setPublishing("Азбука");
		book2.setPrice(7);
		book2.setBinding("твёрдый");

		Book book3 = new Book(3, "На дне", List.of("Горький"), 2018, 416 );
		book3.setPublishing("Азбука");
		book3.setPrice(7);
		book3.setBinding("твёрдый");

		Book book4 = new Book(4, "12 стульев", List.of("Ильф", "Петров"), 2017, 448 );
		book4.setPublishing("АСТ");
		book4.setPrice(11);
		book4.setBinding("мягкий");

		Book book5 = new Book(5, "Гроза", List.of("Островский"), 2020, 256);
		book5.setPublishing("Азбука");
		book5.setPrice(7);
		book5.setBinding("твёрдый");

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);

		View view = new View();

		view.printBooksByAuthor(books, "Петров");
		view.printBooksByPublishing(books, "Азбука");
		view.printPublishingAfterYear(books, 2018);

	}
}
