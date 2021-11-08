package by.jonline.module6.task3.dao.impl;

import by.jonline.module6.task3.dao.ArchiveDAO;
import by.jonline.module6.task3.entity.*;
import by.jonline.module6.task3.parser.CaseDOMParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class XMLArchiveDAO implements ArchiveDAO {
	private final String ACHIVE_FILE_PATH = "resources/achieve.xml";
	private CaseDOMParser caseParser;

	public XMLArchiveDAO(){
		caseParser = new CaseDOMParser(ACHIVE_FILE_PATH);
	}

	@Override
	public List<Case> findCaseById(int id) throws IOException, ParserConfigurationException, SAXException {
		List<Case> results = caseParser.findCaseByTag("id", String.valueOf(id));

		if (results.size() > 1) {
			throw new SAXException("Найдено несколько студентов с одинаковым id. База данных повреждена");
		}
		return results;
	}

	@Override
	public List<Case> findCaseBySurname(String name) throws IOException, ParserConfigurationException, SAXException {
		List<Case> results = caseParser.findCaseByTag("surname", name);
		return results;
	}

	@Override
	public List<Case> findCaseByFaculty(Faculty faculty) throws IOException, ParserConfigurationException, SAXException {
		List<Case> results = caseParser.findCaseByTag("faculty", faculty.name());
		return results;
	}

	@Override
	public boolean createNewCase(Case newCase) throws ParserConfigurationException, TransformerException, IOException, SAXException {
		List<Case> archive = loadArchive();
		archive.add(newCase);
		saveArchive(archive);
		return true;
	}

	@Override
	public boolean modifyCase(Case newCase) throws ParserConfigurationException, TransformerException, IOException, SAXException {
		List<Case> archive = loadArchive();

		for (Case caseObj : archive) {
			if (caseObj.getId() == newCase.getId()) {
				caseObj.setStudent(newCase.getStudent());
				caseObj.setFaculty(newCase.getFaculty());
				caseObj.setEducationForm(newCase.getEducationForm());
				caseObj.setPaymentType(newCase.getPaymentType());
				caseObj.setCreationDate(LocalDate.now());

				break;
			}
		}

		saveArchive(archive);
		return true;
	}

	private List<Case> loadArchive() throws IOException, ParserConfigurationException, SAXException {
		List<Case> cases = caseParser.findCaseByTag("", "");
		return cases;
	}

	private void saveArchive(List<Case> achieve) throws ParserConfigurationException, TransformerException {
		caseParser.saveCaseList(achieve);
	}
}
