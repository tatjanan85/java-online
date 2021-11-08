package by.jonline.module6.task3.parser;

import by.jonline.module6.task3.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CaseDOMParser {

	private String filename;
	private DocumentBuilderFactory factory;
	private int lastId;

	public CaseDOMParser(String filename) {
		this.filename = filename;
		factory = DocumentBuilderFactory.newInstance();
	}

	public List<Case> findCaseByTag(String tagName, String tagValue) throws IOException, SAXException, ParserConfigurationException {
		List<Case> results = new ArrayList<>();

		DocumentBuilder reader = factory.newDocumentBuilder();
		Document doc = reader.parse(filename);

		Element root = doc.getDocumentElement();
		lastId =Integer.parseInt(root.getAttribute("lastId"));

		NodeList casesList = root.getElementsByTagName("case");

		for (int i = 0; i < casesList.getLength(); i++) {
			Element caseElement = (Element) casesList.item(i);
			Case caseObj = getCase(caseElement, tagName, tagValue);

			if (caseObj != null) {
				results.add(caseObj);
			}
		}

		return results;
	}

	private Case getCase(Element caseElement, String tagName, String tagValue) throws SAXException {
		Case caseObj = new Case();
		Student student;

		String id = caseElement.getAttribute("id");
		if (tagName.equals("id") && !id.equals(tagValue))
			return null;
		caseObj.setId(Integer.parseInt(id));

		student = getStudent(caseElement, tagName, tagValue);
		if (student == null) {
			return null;
		}
		caseObj.setStudent(student);

		String facultyStr = getElementTextContent(caseElement, "faculty");
		for (Faculty faculty : Faculty.values()) {
			if (faculty.getName().equals(facultyStr)) {
				if (tagName.equals("faculty") && faculty != Faculty.valueOf(tagValue.toUpperCase()))
					return null;

				caseObj.setFaculty(faculty);
				break;
			}
		}

		if (caseObj.getFaculty() == null) {
			throw new SAXException("Ошибка разбора XML. Факультет не найден");
		}


		String form = getElementTextContent(caseElement, "educationForm");
		for (EducationForm educationForm : EducationForm.values()) {
			if (educationForm.getName().equals(form)) {
				caseObj.setEducationForm(educationForm);
				break;
			}
		}

		if (caseObj.getEducationForm() == null) {
			throw new SAXException("Ошибка разбора XML. Форма обучения не найдена");
		}


		String payment = getElementTextContent(caseElement, "paymentType");
		for (PaymentType paymentType: PaymentType.values()) {
			if (paymentType.getName().equals(payment)) {
				caseObj.setPaymentType(paymentType);
				break;
			}
		}

		if (caseObj.getEducationForm() == null) {
			throw new SAXException("Ошибка разбора XML. Форма оплатф не найдена");
		}


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String dateStr = getElementTextContent(caseElement, "creationDate");
		caseObj.setCreationDate(LocalDate.parse(dateStr, formatter));

		return caseObj;
	}

	private Student getStudent(Element caseElement, String tagName, String tagValue) {
		Student student = new Student();

		Element studentElement = (Element) caseElement.getElementsByTagName("student").item(0);

		student.setSurname(getElementTextContent(studentElement, "surname"));
		if (tagName.equals("surname") && !student.getSurname().equals(tagValue)) {
			return null;
		}

		student.setName(getElementTextContent(studentElement, "name"));
		student.setPatronymic(getElementTextContent(studentElement, "patronymic"));
		student.setAddress(getElementTextContent(studentElement, "address"));
		student.setDocumentId(getElementTextContent(studentElement, "documentId"));

		return student;
	}

	private String getElementTextContent(Element element, String childElementName) {
		NodeList nList = element.getElementsByTagName(childElementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}

	public void saveCaseList(List<Case> cases) throws ParserConfigurationException, TransformerException {
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element rootElement = doc.createElement("cases");
		doc.appendChild(rootElement);

		for (Case caseObj : cases) {
			Element caseElement = doc.createElement("case");
			if (caseObj.getId() != 0) {
				caseElement.setAttribute("id", String.valueOf(caseObj.getId()));
				rootElement.setAttribute("lastId", String.valueOf(lastId));
			} else {
				caseElement.setAttribute("id", String.valueOf(lastId + 1));
				rootElement.setAttribute("lastId", String.valueOf(lastId + 1));
			}

			Element studentElement = doc.createElement("student");

			Element nameElement = doc.createElement("name");
			nameElement.appendChild(doc.createTextNode(caseObj.getStudent().getName()));
			studentElement.appendChild(nameElement);

			Element surnameElement = doc.createElement("surname");
			surnameElement.appendChild(doc.createTextNode(caseObj.getStudent().getSurname()));
			studentElement.appendChild(surnameElement);

			Element patronymicElement = doc.createElement("patronymic");
			patronymicElement.appendChild(doc.createTextNode(caseObj.getStudent().getPatronymic()));
			studentElement.appendChild(patronymicElement);

			Element addressElement = doc.createElement("address");
			addressElement.appendChild(doc.createTextNode(caseObj.getStudent().getAddress()));
			studentElement.appendChild(addressElement);

			Element docIdElement = doc.createElement("documentId");
			docIdElement.appendChild(doc.createTextNode(caseObj.getStudent().getDocumentId()));
			studentElement.appendChild(docIdElement);

			caseElement.appendChild(studentElement);

			Element facultyElement = doc.createElement("faculty");
			facultyElement.appendChild(doc.createTextNode(caseObj.getFaculty().toString()));
			caseElement.appendChild(facultyElement);

			Element eduFormElement = doc.createElement("educationForm");
			eduFormElement.appendChild(doc.createTextNode(caseObj.getEducationForm().toString()));
			caseElement.appendChild(eduFormElement);

			Element paymentTypeElement = doc.createElement("paymentType");
			paymentTypeElement.appendChild(doc.createTextNode(caseObj.getPaymentType().toString()));
			caseElement.appendChild(paymentTypeElement);

			Element creationDateElement = doc.createElement("creationDate");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			creationDateElement.appendChild(doc.createTextNode(caseObj.getCreationDate().format(formatter)));
			caseElement.appendChild(creationDateElement);

			rootElement.appendChild(caseElement);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(filename);

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

		transformer.transform(source, result);
	}
}
