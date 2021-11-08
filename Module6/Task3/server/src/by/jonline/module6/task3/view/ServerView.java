package by.jonline.module6.task3.view;

import by.jonline.module6.task3.service.ClientInteractionService;
import by.jonline.module6.task3.service.impl.SocketClientInteractionService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ServerView {

	private static ServerView instance;

	private ServerView() {
	}

	public static ServerView getInstance() {
		if (instance == null) {
			instance = new ServerView();
		}
		return instance;
	}

	public void startServer() {

		System.out.println("server starts");

		ClientInteractionService clientService = null;
		try {
			clientService = SocketClientInteractionService.getInstance();
			while (clientService.getSocketConnection() == null || clientService.getSocketConnection().isClosed() ) {
				clientService.setSocketConnection();
				System.out.println("Сервер ожидает подключения");

				while (!clientService.getSocketConnection().isClosed()) {
					clientService.readData();
				}
				System.out.println("Клиент отключился от сервера");
			}

		} catch (ParserConfigurationException | ClassNotFoundException |
				SAXException | TransformerException | IOException e) {
			printError(e.getMessage());
			try {
				clientService.sendData(new Exception(e));
			} catch (IOException ioException) {
				printError(ioException.getMessage());
			}
		}

		System.out.println("server is closed");

	}

	public void printError(String message) {
		System.out.println(message);
	}


}
