package by.jonline.module6.task2.service;

import by.jonline.module6.task2.service.impl.NotepadServiceImpl;

public final class ServiceProvider {
	private static ServiceProvider instance;
	private NotepadService notepadService;

	private ServiceProvider() {
		notepadService = new NotepadServiceImpl();
	}

	public static ServiceProvider getInstance() {
		if (instance == null ){
			instance = new ServiceProvider();
		}
		return instance;
	}

	public NotepadService getNotepadService() {
		return notepadService;
	}

}
