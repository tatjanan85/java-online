package by.jonline.module6.task1.service.impl;

import by.jonline.module6.task1.dao.DAOProvider;
import by.jonline.module6.task1.dao.LibraryDAO;
import by.jonline.module6.task1.entity.Book;
import by.jonline.module6.task1.exception.InvalidFileBookFormatException;
import by.jonline.module6.task1.exception.InvalidFileBookIdFormatException;
import by.jonline.module6.task1.service.LibraryService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

	private final DAOProvider daoProvider;

	public LibraryServiceImpl() throws FileNotFoundException {
		this.daoProvider = DAOProvider.getInstance();
	}

	@Override
	public boolean addBook(Book book) throws IOException, InvalidFileBookIdFormatException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		return libraryDAO.addBook(book);
	}

	@Override
	public boolean deleteBook(int id) throws InvalidFileBookFormatException, IOException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		return libraryDAO.deleteBook(id);
	}

	@Override
	public List<Book> findById(int id) throws InvalidFileBookFormatException, IOException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		List<Book> books = libraryDAO.findById(id);
		return books;
	}

	@Override
	public List<Book> findByAuthor(String author) throws InvalidFileBookFormatException, IOException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		List<Book> books = libraryDAO.findByAuthor(author);
		return books;
	}

	@Override
	public List<Book> findByYear(int year) throws InvalidFileBookFormatException, IOException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		List<Book> books = libraryDAO.findByYear(year);
		return books;
	}

	@Override
	public List<Book> findByKeyword(String keyword) throws IOException, InvalidFileBookFormatException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		List<Book> books = libraryDAO.findByKeyword(keyword);
		return books;
	}

	@Override
	public List<Book> findByPublisher(String publisher) throws IOException, InvalidFileBookFormatException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		List<Book> books = libraryDAO.findByPublisher(publisher);
		return books;
	}

	@Override
	public List<Book> findNextBookBlock(int offset, int blockSize) throws IOException, InvalidFileBookFormatException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		List<Book> books = libraryDAO.findNextBookBlock(offset, blockSize);
		return books;
	}

	public int getBooksQuantity() throws IOException {
		LibraryDAO libraryDAO = daoProvider.getLibraryDAO();
		int booksQuantity = libraryDAO.getBooksQuantity();
		return booksQuantity;
	}
}
