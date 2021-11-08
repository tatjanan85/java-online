package by.jonline.module6.task1.dao.impl;

import by.jonline.module6.task1.dao.LibraryDAO;
import by.jonline.module6.task1.entity.Book;
import by.jonline.module6.task1.entity.EBook;
import by.jonline.module6.task1.entity.PaperBook;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.exception.InvalidFileBookIdFormatException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLibraryDAO implements LibraryDAO {

	private final String BOOKS_FILE_NAME = "resources/books.txt";
	private final String BOOK_ID_FILE_NAME = "resources/book_id.txt";

	public FileLibraryDAO() {
	}

	@Override
	public boolean addBook(Book book) throws IOException, InvalidFileBookIdFormatException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE_NAME, StandardCharsets.UTF_8, true));
		String info[] = new String[8];

		info[2] = book.getTitle();
		info[3] = book.getAuthor();
		info[4] = String.valueOf(book.getPages());
		info[5] = book.getPublisher();
		info[6] = String.valueOf(book.getYear());

		if (book instanceof PaperBook) {
			info[1] = "paper";
			info[7] = ((PaperBook) book).getCover().toString();
		} else {
			info[1] = "ebook";
			info[7] = ((EBook) book).getFileFormat();
		}

		BufferedReader reader = new BufferedReader(new FileReader(BOOK_ID_FILE_NAME));


		int last_id;
		try {
			last_id = Integer.parseInt(reader.readLine());
			reader.close();
			info[0] = String.valueOf(last_id + 1);
			String line = String.join("|", info);
			writer.newLine();
			writer.write(line);

			BufferedWriter writerId = new BufferedWriter(new FileWriter(BOOK_ID_FILE_NAME, StandardCharsets.UTF_8, false));

			writerId.write(String.valueOf(last_id + 1));
			writerId.flush();

		} catch (NumberFormatException e) {
			throw new InvalidFileBookIdFormatException();
		} finally {
			writer.close();
		}

		return true;
	}

	@Override
	public boolean deleteBook(int id) throws IOException, InvalidFileBookFormatException {
		File source = new File(BOOKS_FILE_NAME);
		File temp = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(source));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

		String line;
		Book book;

		while ((line = reader.readLine()) != null) {
			book = parseBook(line);

			if (book.getId() != id) {
				writer.write(line);
				writer.newLine();
			}
		}

		writer.flush();
		reader.close();
		writer.close();

		source.delete();
		temp.renameTo(source);

		return true;
	}

	@Override
	public List<Book> findById(int id) throws InvalidFileBookFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_NAME));
		List<Book> result = new ArrayList<Book>();
		String line;
		Book book;

		while ((line = reader.readLine()) != null) {
			book = parseBook(line);

			if (book.getId() == id) {
				result.add(book);
			}
		}

		reader.close();
		return result;
	}

	@Override
	public List<Book> findByYear(int year) throws InvalidFileBookFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_NAME));
		List<Book> result = new ArrayList<Book>();
		String line;
		Book book;

		while ((line = reader.readLine()) != null) {
			book = parseBook(line);

			if (book.getYear() == year) {
				result.add(book);
			}
		}

		reader.close();
		return result;
	}

	@Override
	public List<Book> findByAuthor(String author) throws InvalidFileBookFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_NAME));
		List<Book> result = new ArrayList<Book>();
		String line;
		Book book;

		while ((line = reader.readLine()) != null) {
			book = parseBook(line);

			if (book.getAuthor().indexOf(author) > -1) {
				result.add(book);
			}
		}

		reader.close();
		return result;
	}

	@Override
	public List<Book> findByKeyword(String keyword) throws IOException, InvalidFileBookFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_NAME));
		List<Book> result = new ArrayList<Book>();
		String line;
		Book book;

		while ((line = reader.readLine()) != null) {
			book = parseBook(line);

			if (book.getTitle().toLowerCase().indexOf(keyword.toLowerCase()) > -1) {
				result.add(book);
			}
		}

		reader.close();
		return result;
	}

	@Override
	public List<Book> findByPublisher(String publisher) throws IOException, InvalidFileBookFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_NAME));
		List<Book> result = new ArrayList<Book>();
		String line;
		Book book;

		while ((line = reader.readLine()) != null) {
			book = parseBook(line);

			if (book.getPublisher().equalsIgnoreCase(publisher)) {
				result.add(book);
			}
		}

		reader.close();
		return result;
	}

	@Override
	public List<Book> findNextBookBlock(int offset, int blockSize) throws IOException, InvalidFileBookFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_NAME));
		List<Book> result = new ArrayList<Book>();
		String line;
		Book book;

		System.out.println(offset + " " + blockSize);
		try (LineNumberReader lReader = new LineNumberReader(reader)) {

			while (lReader.getLineNumber() < offset - 1 &&
					(line = lReader.readLine()) != null);

			while ((line = lReader.readLine()) != null &&
					lReader.getLineNumber() <= offset - 1 + blockSize) {

				book = parseBook(line);
				result.add(book);
			}
		}

		reader.close();
		return result;
	}

	private Book parseBook(String line) throws InvalidFileBookFormatException {

		String[] info = line.split("\\|");

		if (info.length != 8) {
			throw new InvalidFileBookFormatException("Неверный формат данных. Неверное количество полей");
		}

		int id;
		try {
			id = Integer.parseInt(info[0]);
		} catch (NumberFormatException e) {
			throw new InvalidFileBookFormatException("Неверный формат данных. Неверный формат id");
		}

		String title = info[2];
		String author = info[3];

		int pages;
		int year;

		try {
			pages = Integer.parseInt(info[4]);
		} catch (NumberFormatException e) {
			throw new InvalidFileBookFormatException("Неверный формат данных. Неверный формат страниц");
		}

		String publisher = info[5];

		try {
			year = Integer.parseInt(info[6]);
		} catch (NumberFormatException e) {
			throw new InvalidFileBookFormatException("Неверный формат данных. Неверный формат года издания");
		}

		switch (info[1]) {
			case "paper":
				PaperBook.Cover cover;
				if (info[7].equals(PaperBook.Cover.HARD.toString())) {
					cover = PaperBook.Cover.HARD;
				} else if (info[7].equals(PaperBook.Cover.SOFT.toString())) {
					cover = PaperBook.Cover.SOFT;
				} else {
					throw new InvalidFileBookFormatException("Неверный формат данных. Неверный формат обложки");
				}

				PaperBook pBook = new PaperBook(title, author, pages, publisher, year);
				pBook.setId(id);
				pBook.setCover(cover);

				return pBook;

			case "ebook" :
				String fileFormat = info[7];

				EBook eBook = new EBook(title, author, pages, publisher, year);
				eBook.setId(id);
				eBook.setFileFormat(fileFormat);

				return eBook;
			default:
				throw new InvalidFileBookFormatException("Неверный формат данных. Такой обложки не существует");
		}

	}

	public int getBooksQuantity() throws IOException {
		LineNumberReader reader = new LineNumberReader(new FileReader(BOOKS_FILE_NAME));
		while (reader.readLine() != null);

		int booksQuantity = reader.getLineNumber();
		reader.close();

		return booksQuantity;
	}
}
