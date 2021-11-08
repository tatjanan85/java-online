package by.jonline.module6.task3.service;

import by.jonline.module6.task3.service.impl.ArchiveServiceImpl;
import by.jonline.module6.task3.service.impl.UserServiceImpl;

import java.io.IOException;

public class ServiceProvider {
	private static ServiceProvider instance;

	private final UserService userService;
	private final ArchiveService archiveService;

	private ServiceProvider() throws IOException {
		userService = new UserServiceImpl();
		archiveService = new ArchiveServiceImpl();
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

	public ArchiveService getAchieveService() {
		return archiveService;
	}

}
