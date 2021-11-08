package by.jonline.module6.task3.service.impl;

import by.jonline.module6.task3.entity.User;
import by.jonline.module6.task3.exception.ServerException;
import by.jonline.module6.task3.service.ServerInteractionService;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SocketServerInteractionService implements ServerInteractionService {

	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private User currentUser;

	private final String CONNECTION_IP = "192.168.7.96";
	private final int CONNECTION_PORT = 2048;

	public SocketServerInteractionService() throws IOException {
		Socket socket = new Socket(CONNECTION_IP, CONNECTION_PORT);
		writer = new ObjectOutputStream(socket.getOutputStream());
		reader = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public boolean sendLoginData(String login, String password) throws IOException, NoSuchAlgorithmException, ClassNotFoundException, ServerException {
		User user = new User(login, getPasswordHash(password));
		writer.writeObject(user);

		Object data = readData();

		if (data != null) {
			if (data instanceof Exception){
				throw new ServerException(((Exception) data).getCause() + ((Exception) data).getMessage());
			}
			currentUser = (User) data;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object sendData(Object data) throws IOException, ClassNotFoundException, ServerException {
		writer.writeObject(data);

		return readData();
	}

	@Override
	public Object readData() throws IOException, ClassNotFoundException, ServerException {
		Object data;
		while (true) {
			data = reader.readObject();
			break;
		}

		if (data instanceof Exception){
			throw new ServerException(((Exception) data).getCause() + ((Exception) data).getMessage());
		}

		return data;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	private String getPasswordHash(String password) throws NoSuchAlgorithmException {
		MessageDigest md = null;

		md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes(StandardCharsets.UTF_8));

		BigInteger bigInt = new BigInteger(1, md.digest());
		String md5Hex = bigInt.toString(16);

		return md5Hex;
	}
}
