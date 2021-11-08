package by.jonline.module6.task1.dao;

import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.entity.User;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;

import java.io.IOException;
import java.util.List;

public interface UserDAO {
	User authorization(String login, String password) throws InvalidFileUserFormatException, IOException;
	List<User> getUsersByRole(Role role) throws IOException, InvalidFileUserFormatException;

}
