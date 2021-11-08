package by.jonline.module6.task3.service.impl;

import by.jonline.module6.task3.entity.*;
import by.jonline.module6.task3.service.ArchiveService;
import by.jonline.module6.task3.service.ClientInteractionService;
import by.jonline.module6.task3.service.ServiceProvider;
import by.jonline.module6.task3.service.UserService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class SocketClientInteractionService implements ClientInteractionService {
	private static ClientInteractionService instance;

	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private ServerSocket server;
	private Socket socket;
	private UserService userService = ServiceProvider.getInstance().getUserService();
	private ArchiveService archiveService = ServiceProvider.getInstance().getAchieveService();

	private final int CONNECTION_PORT = 2048;

	private SocketClientInteractionService() throws IOException {
		server = new ServerSocket(CONNECTION_PORT);
	}

	public static ClientInteractionService getInstance() throws IOException {
		if (instance == null) {
			instance = new SocketClientInteractionService();
		}
		return instance;
	}

	@Override
	public void setSocketConnection() throws IOException {
		socket = server.accept();
		reader = new ObjectInputStream(socket.getInputStream());
		writer = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public Socket getSocketConnection() {
		return socket;
	}

	@Override
	public void readData() throws IOException, ClassNotFoundException, ParserConfigurationException,
									SAXException, TransformerException {
		Object data;

		data = reader.readObject();

		if (data instanceof User) {
			userService.authorization(((User) data).getLogin(), ((User) data).getPassword());
			sendData(userService.getCurrentUser());
		}

		if (data instanceof SearchObject) {
			String type = ((SearchObject) data).getType();


			switch (type) {
				case "id":
					data = archiveService.findCaseById((Integer) ((SearchObject) data).getData());
					break;
				case "faculty":
					data = archiveService.findCaseByFaculty((Faculty) ((SearchObject) data).getData());
					break;
				case "surname":
					data = archiveService.findCaseBySurname((String) ((SearchObject) data).getData());
					break;
			}

			sendData(data);
		}

		if (data instanceof SaveObject) {
			String type = ((SaveObject) data).getType();
			System.out.println(type);
			System.out.println(((SaveObject) data).getCase());

			switch (type) {
				case "new":
					archiveService.createNewCase((Case) ((SaveObject) data).getCase());
					break;
				case "modify":
					archiveService.modifyCase((Case) ((SaveObject) data).getCase());
					break;
			}

			sendData(Boolean.TRUE);
		}

		if (data instanceof String) {
			if (((String) data).equals("exit")) {
				sendData(Boolean.TRUE);

				reader.close();
				writer.close();
				socket.close();
			}
		}
	}

	@Override
	public void sendData(Object object) throws IOException {
		writer.writeObject(object);
	}


}
