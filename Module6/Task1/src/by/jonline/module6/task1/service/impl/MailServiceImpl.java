package by.jonline.module6.task1.service.impl;

import by.jonline.module6.task1.dao.DAOProvider;
import by.jonline.module6.task1.entity.Mail;
import by.jonline.module6.task1.entity.User;
import by.jonline.module6.task1.service.MailService;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class MailServiceImpl implements MailService {

	private final DAOProvider daoProvider;
	private Properties properties;
	private Session session;

	public MailServiceImpl() throws IOException {
		this.daoProvider = DAOProvider.getInstance();

		properties = daoProvider.getMailDAO().getMailData();

		session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(properties.getProperty("mail.user.name"),
								properties.getProperty("mail.user.password"));
					}
				});


	}

	@Override
	public boolean sendMail(Mail mail) throws MessagingException {
		List<User> users = mail.getToUsers();

		if (users.size() > 0) {
			String addresses = "";

			for (int i = 0; i < users.size(); i++) {
				addresses = addresses + "," + users.get(i).getEmail();
			}
			addresses = addresses.substring(1);

			Message mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(mail.getFrom()));
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
			mimeMessage.setSubject(mail.getSubject());

			MimeBodyPart part1 = new MimeBodyPart();
			part1.setText(mail.getMessage());

			Multipart mp = new MimeMultipart();
			mp.addBodyPart(part1);

			if (mail.getAttachmentPath() != null) {
				MimeBodyPart part2 = new MimeBodyPart();
				FileDataSource fileDataSource = new FileDataSource(mail.getAttachmentPath());
				part2.setDataHandler(new DataHandler(fileDataSource));
				part2.setFileName(fileDataSource.getName());

				mp.addBodyPart(part2);
			}

			mimeMessage.setContent(mp);

			Transport.send(mimeMessage);

			return true;
		} else {

		}
		return false;
	}

}
