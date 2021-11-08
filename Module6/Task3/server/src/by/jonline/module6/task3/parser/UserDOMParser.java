package by.jonline.module6.task3.parser;

import by.jonline.module6.task3.entity.Role;
import by.jonline.module6.task3.entity.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UserDOMParser {

	private String filename;
	private DocumentBuilderFactory factory;

	public UserDOMParser(String filename) {
		this.filename = filename;
		factory = DocumentBuilderFactory.newInstance();
	}

	public User findUser(String login) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilder reader = factory.newDocumentBuilder();
		Document doc = reader.parse(filename);
		User user = null;

		Element root = doc.getDocumentElement();

		NodeList userList = root.getElementsByTagName("user");

		for (int i = 0; i < userList.getLength(); i++) {
			Element userElement = (Element) userList.item(i);
			Element loginElement = (Element) userElement.getElementsByTagName("login").item(0);

			if (loginElement.getTextContent().equals(login)) {
				Element passElement = (Element) userElement.getElementsByTagName("password").item(0);
				Element roleElement = (Element) userElement.getElementsByTagName("role").item(0);

				user = new User(login, passElement.getTextContent());
				if (roleElement.getTextContent().equals("администратор")) {
					user.setRole(Role.ADMIN);
				} else {
					user.setRole(Role.USER);
				}

				break;
			}
		}
		return user;
	}

}
