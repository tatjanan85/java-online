package by.jonline.module6.task3.service;

import by.jonline.module6.task3.service.impl.SocketServerInteractionService;

import java.io.IOException;

public class ClientServiceProvider {

	private static ClientServiceProvider instance;

	private final ServerInteractionService serverInteractionService;

	private ClientServiceProvider() throws IOException {
		serverInteractionService = new SocketServerInteractionService();
	}

	public static ClientServiceProvider getInstance() throws IOException {
		if (instance == null) {
			instance = new ClientServiceProvider();
		}
		return instance;
	}

	public ServerInteractionService getServerInteractionService() {
		return serverInteractionService;
	}
}
