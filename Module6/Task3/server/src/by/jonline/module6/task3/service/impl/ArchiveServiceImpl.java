package by.jonline.module6.task3.service.impl;

import by.jonline.module6.task3.dao.ArchiveDAO;
import by.jonline.module6.task3.dao.DAOProvider;
import by.jonline.module6.task3.entity.*;
import by.jonline.module6.task3.service.ArchiveService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class ArchiveServiceImpl implements ArchiveService {

	private ArchiveDAO archiveDAO = DAOProvider.getInstance().getAchieveDAO();

	@Override
	public List<Case> findCaseById(int id) throws IOException, ParserConfigurationException, SAXException {
		List<Case> results = archiveDAO.findCaseById(id);
		return results;
	}

	@Override
	public List<Case> findCaseBySurname(String name) throws IOException, ParserConfigurationException, SAXException {
		List<Case> results = archiveDAO.findCaseBySurname(name);
		return results;
	}

	@Override
	public List<Case> findCaseByFaculty(Faculty faculty) throws IOException, ParserConfigurationException, SAXException {
		List<Case> results = archiveDAO.findCaseByFaculty(faculty);
		return results;
	}

	@Override
	public boolean createNewCase(Case caseObj) throws ParserConfigurationException, IOException, TransformerException, SAXException {
		archiveDAO.createNewCase(caseObj);
		return true;
	}

	@Override
	public boolean modifyCase(Case caseObj) throws ParserConfigurationException, IOException, TransformerException, SAXException {
		archiveDAO.modifyCase(caseObj);
		return false;
	}
}
