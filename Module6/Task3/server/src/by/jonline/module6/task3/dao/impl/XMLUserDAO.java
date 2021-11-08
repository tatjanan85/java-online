package by.jonline.module6.task3.dao.impl;

import by.jonline.module6.task3.dao.UserDAO;
import by.jonline.module6.task3.entity.User;
import by.jonline.module6.task3.parser.UserDOMParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLUserDAO implements UserDAO {
	private final String USERS_FILE_PATH = "resources/users.xml";
	private UserDOMParser userParser;

	public XMLUserDAO(){
		userParser = new UserDOMParser(USERS_FILE_PATH);
	}

	@Override
	public User authorization(String login, String password) throws IOException, ParserConfigurationException, SAXException {
		User user;

		user = userParser.findUser(login);

		if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
			return user;
		}

		return null;
	}
}
