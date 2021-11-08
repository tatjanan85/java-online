package by.jonline.module6.task3.service;

import by.jonline.module6.task3.entity.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface ArchiveService {

	List<Case> findCaseById(int id) throws IOException, ParserConfigurationException, SAXException;
	List<Case> findCaseBySurname(String name) throws IOException, ParserConfigurationException, SAXException;
	List<Case> findCaseByFaculty(Faculty faculty) throws IOException, ParserConfigurationException, SAXException;
	boolean createNewCase(Case caseobj) throws ParserConfigurationException, IOException, TransformerException, SAXException;
	boolean modifyCase(Case caseobj) throws ParserConfigurationException, IOException, TransformerException, SAXException;
}
