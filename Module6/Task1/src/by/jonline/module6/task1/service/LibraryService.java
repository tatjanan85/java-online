package by.jonline.module6.task1.service;

import by.jonline.module6.task1.entity.Book;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.exception.InvalidFileBookIdFormatException;

import java.io.IOException;
import java.util.List;

public interface LibraryService {

	boolean addBook(Book book) throws IOException, InvalidFileBookIdFormatException;
	boolean deleteBook(int id) throws InvalidFileBookFormatException, IOException;
	List<Book> findById(int id) throws InvalidFileBookFormatException, IOException;
	List<Book> findByAuthor(String author) throws InvalidFileBookFormatException, IOException;
	List<Book> findByYear(int year) throws InvalidFileBookFormatException, IOException;
	List<Book> findByKeyword(String keyword) throws IOException, InvalidFileBookFormatException;
	List<Book> findByPublisher(String publisher) throws IOException, InvalidFileBookFormatException;
	List<Book> findNextBookBlock(int offset, int blockSize) throws IOException, InvalidFileBookFormatException;
	int getBooksQuantity() throws IOException;
}
