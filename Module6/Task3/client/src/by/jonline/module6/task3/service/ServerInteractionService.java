package by.jonline.module6.task3.service;

import by.jonline.module6.task3.entity.User;
import by.jonline.module6.task3.exception.ServerException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface ServerInteractionService {

	boolean sendLoginData(String login, String password) throws IOException, NoSuchAlgorithmException, ClassNotFoundException, ServerException;
	Object sendData(Object data) throws IOException, ClassNotFoundException, ServerException;
	Object readData() throws IOException, ClassNotFoundException, ServerException;

	User getCurrentUser();

}
