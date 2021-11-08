package by.jonline.module6.task1.service;

import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.entity.User;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;
import by.jonline.module6.task1.exception.AutorizationException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

	boolean autorization(String login, String password) throws InvalidFileUserFormatException, IOException, AutorizationException, NoSuchAlgorithmException;
	User getCurrentUser();
	List<User> getUsersByRole(Role role) throws IOException, InvalidFileUserFormatException;

}
