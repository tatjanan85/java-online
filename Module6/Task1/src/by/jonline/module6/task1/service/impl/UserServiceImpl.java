package by.jonline.module6.task1.service.impl;

import by.jonline.module6.task1.dao.DAOProvider;
import by.jonline.module6.task1.dao.UserDAO;
import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.entity.User;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;
import by.jonline.module6.task1.exception.AutorizationException;
import by.jonline.module6.task1.service.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServiceImpl implements UserService {

	private final DAOProvider daoProvider;
	private User currentUser;

	public UserServiceImpl() throws FileNotFoundException {
		this.daoProvider = DAOProvider.getInstance();
	}

	@Override
	public boolean autorization(String login, String password)
			throws InvalidFileUserFormatException, IOException, AutorizationException, NoSuchAlgorithmException {
		if (!validateLogin(login)) {
			throw new AutorizationException("Ошибка авторизации. Логин содержит недопустимые символы");
		}

		UserDAO userDAO = daoProvider.getUserDAO();

		String passwordHash = getPasswordHash(password);

		User user = userDAO.authorization(login, passwordHash);
		if (user != null) {
			currentUser = user;
			return true;
		}

		return false;
	}

	@Override
	public List<User> getUsersByRole(Role role) throws IOException, InvalidFileUserFormatException {
		UserDAO userDAO = daoProvider.getUserDAO();
		List<User> users = userDAO.getUsersByRole(role);
		return  users;
	}

	private boolean validateLogin(String login) {
		String pattern = "^[a-zA-Z0-9]{1}[a-zA-Z0-9_-]{2,}$";
		return login.matches(pattern);
	}

	private String getPasswordHash(String password) throws NoSuchAlgorithmException {
		MessageDigest md = null;

		md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes(StandardCharsets.UTF_8));

		BigInteger bigInt = new BigInteger(1, md.digest());
		String md5Hex = bigInt.toString(16);

		return md5Hex;

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrenUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
