package by.jonline.module6.task1.service;

import by.jonline.module6.task1.entity.Mail;
import by.jonline.module6.task1.entity.User;

import javax.mail.MessagingException;
import java.util.List;

public interface MailService {
	boolean sendMail(Mail mail) throws MessagingException;
}
