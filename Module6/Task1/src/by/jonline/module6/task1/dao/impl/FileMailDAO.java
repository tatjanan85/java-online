package by.jonline.module6.task1.dao.impl;

import by.jonline.module6.task1.dao.MailDAO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileMailDAO implements MailDAO {

	private String MAIL_FILE_NAME = "resources/mail.properties";

	@Override
	public Properties getMailData() throws IOException {
		Properties props = new Properties();
		props.load(new FileReader(MAIL_FILE_NAME));

		return props;
	}
}
