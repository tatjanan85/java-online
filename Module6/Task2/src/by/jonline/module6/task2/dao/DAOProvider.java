package by.jonline.module6.task2.dao;

import by.jonline.module6.task2.dao.impl.FileNoteDAO;

public final class DAOProvider {
	private static DAOProvider instance;
	private NoteDAO noteDAO;

	private DAOProvider(){
		noteDAO = new FileNoteDAO();
	}

	public static DAOProvider getInstance() {
		if (instance == null) {
			instance = new DAOProvider();
		}
		return instance;
	}

	public NoteDAO getNoteDAO() {
		return noteDAO;
	}
}
