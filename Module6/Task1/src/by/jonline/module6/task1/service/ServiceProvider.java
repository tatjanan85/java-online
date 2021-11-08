package by.jonline.module6.task1.service;

import by.jonline.module6.task1.service.impl.LibraryServiceImpl;
import by.jonline.module6.task1.service.impl.MailServiceImpl;
import by.jonline.module6.task1.service.impl.UserServiceImpl;

import java.io.IOException;

public final class ServiceProvider {

	private static ServiceProvider instance;

	private final UserService userService;
	private final LibraryService libraryService;
	private final MailService mailService;

	private ServiceProvider() throws IOException {
		userService = new UserServiceImpl();
		libraryService = new LibraryServiceImpl();
		mailService = new MailServiceImpl();
	}

	public static ServiceProvider getInstance() throws IOException {
		if (instance == null) {
			instance = new ServiceProvider();
		}
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

	public MailService getMailService() {
		return mailService;
	}
}
