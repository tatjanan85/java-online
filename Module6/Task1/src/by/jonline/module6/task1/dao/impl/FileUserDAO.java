package by.jonline.module6.task1.dao.impl;

import by.jonline.module6.task1.dao.UserDAO;
import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.entity.User;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileUserDAO implements UserDAO {

	private final String USER_FILE_NAME = "resources/users.txt";

	public FileUserDAO()  {
	}

	@Override
	public User authorization(String login, String password) throws InvalidFileUserFormatException, IOException {
		User user;
		String line;

		BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_NAME));

		while ((line = reader.readLine()) != null) {
			user = parseUser(line);

			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				reader.close();
				return user;
			}
		}

		reader.close();

		return null;
	}

	@Override
	public List<User> getUsersByRole(Role role) throws IOException, InvalidFileUserFormatException {
		List<User> users = new ArrayList<User>();
		User user;
		String line;

		BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_NAME));

		while ((line = reader.readLine()) != null) {
			user = parseUser(line);

			if (user.getRole().equals(role)) {
				users.add(user);
			}
		}

		reader.close();

		return users;
	}

	private User parseUser(String line) throws InvalidFileUserFormatException {

		String[] info = line.split(" ");

		if (info.length != 4) {
			throw new InvalidFileUserFormatException("Неверный формат данных. Неверное количество полей");
		}

		String login = info[0];

		String password;
		if (isHash(info[1])) {
			password = info[1];
		} else {
			throw new InvalidFileUserFormatException("Неверный формат данных. Формат пароля неверен");
		}

		String email;
		if (isEMail(info[2])) {
			email = info[2];
		} else {
			throw new InvalidFileUserFormatException("Неверный формат данных. Формат e-mail неверен");
		}

		Role role;
		switch (info[3]) {
			case "admin":
				role = Role.ADMIN;
				break;
			case "reader":
				role = Role.READER;
				break;
			default:
				throw new InvalidFileUserFormatException("Неверный формат данных. Такой роли не существует");
		}

		User user = new User(login, password);
		user.setEmail(email);
		user.setRole(role);

		return user;
	}

	private boolean isHash(String value) {
		return value.matches("^[0-9a-f]{32}$");
	}

	private boolean isEMail(String value) {
		return value.matches("^\\S+@{1}\\S+\\.{1}\\S{2,}$");
	}
}
