package by.jonline.module6.task3.dao;

import by.jonline.module6.task3.dao.impl.XMLArchiveDAO;
import by.jonline.module6.task3.dao.impl.XMLUserDAO;

public class DAOProvider {

	private static DAOProvider instance;
	private ArchiveDAO archiveDAO;
	private UserDAO userDAO;

	private DAOProvider() {
		archiveDAO = new XMLArchiveDAO();
		userDAO = new XMLUserDAO();
	}

	public static DAOProvider getInstance() {
		if (instance == null) {
			instance = new DAOProvider();
		}
		return instance;
	}

	public ArchiveDAO getAchieveDAO() {
		return archiveDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
}
