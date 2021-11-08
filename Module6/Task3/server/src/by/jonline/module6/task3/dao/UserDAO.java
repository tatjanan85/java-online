package by.jonline.module6.task3.dao;

import by.jonline.module6.task3.entity.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface UserDAO {

	User authorization(String login, String password) throws IOException, ParserConfigurationException, SAXException;

}
