package by.jonline.module6.task3.service.impl;

import by.jonline.module6.task3.dao.DAOProvider;
import by.jonline.module6.task3.dao.UserDAO;
import by.jonline.module6.task3.entity.User;
import by.jonline.module6.task3.service.UserService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = DAOProvider.getInstance().getUserDAO();
	private User currentUser;

	@Override
	public User getCurrentUser() {
		return currentUser;
	}

	@Override
	public boolean authorization(String login, String passwordHash) throws IOException, ParserConfigurationException, SAXException {

		currentUser = userDAO.authorization(login, passwordHash);

		if (currentUser == null) {
			return false;
		}
		return true;
	}



}
