package by.jonline.module6.task1.dao;

import by.jonline.module6.task1.dao.impl.FileLibraryDAO;
import by.jonline.module6.task1.dao.impl.FileMailDAO;
import by.jonline.module6.task1.dao.impl.FileUserDAO;

import java.io.FileNotFoundException;

public final class DAOProvider {

	private static DAOProvider instance;

	private UserDAO userDAO = new FileUserDAO();
	private LibraryDAO libraryDAO = new FileLibraryDAO();
	private MailDAO mailDAO = new FileMailDAO();

	private DAOProvider() throws FileNotFoundException {};

	public static DAOProvider getInstance() throws FileNotFoundException {
		if (instance == null) {
			instance = new DAOProvider();
		}
		return  instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public LibraryDAO getLibraryDAO() {
		return libraryDAO;
	}

	public MailDAO getMailDAO() {
		return mailDAO;
	}
}
