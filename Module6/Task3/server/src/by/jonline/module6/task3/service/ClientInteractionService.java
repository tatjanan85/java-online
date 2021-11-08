package by.jonline.module6.task3.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.Socket;

public interface ClientInteractionService {

	void readData() throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, TransformerException;
	void sendData(Object object) throws IOException;

	void setSocketConnection() throws IOException;
	Socket getSocketConnection();
}
