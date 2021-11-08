package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.entity.Mail;
import by.jonline.module6.task1.entity.Role;
import by.jonline.module6.task1.entity.User;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;
import by.jonline.module6.task1.view.ActionView;
import by.jonline.module6.task1.view.View;

import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SendBookView implements ActionView {

	private static SendBookView instance;
	private View view = View.getInstance();

	private SendBookView() {}

	public static SendBookView getInstance() {
		if (instance == null) {
			instance = new SendBookView();
		}
		return instance;
	}

	@Override
	public void show() {
		String filePath;
		Scanner reader = view.getReader();
		System.out.println("Введите полный путь и имя файла для отправки " +
				"(если указано только имя, то поиск будет произведен в каталоге программы)");
		reader.nextLine();
		filePath = reader.nextLine();
		boolean isExist = Files.exists(Paths.get(filePath));
		//отправить администратору
		if (isExist) {
			List<User> users = null;
			try {
				users = view.getUserService().getUsersByRole(Role.ADMIN);
				String from = view.getUserService().getCurrentUser().getEmail();
				Mail mail = new Mail(from, users, "Запрос на добавление новой книги");
				mail.setMessage("Запрос на добавление новой книги");
				mail.setAttachmentPath(filePath);
				boolean isSent = view.getMailService().sendMail(mail);

				if (isSent) {
					System.out.println("Письмо успешно отправлено");
				}
			} catch (IOException e) {
				view.printError("Ошибки ввода-вывода");
			} catch (InvalidFileUserFormatException e) {
				view.printError(e.getMessage());
			} catch (MessagingException e) {
				view.printError("Ошибка отправки почтового сообщения: " + e.getMessage());
			}

		} else {
			view.printError("Файл не найден");
		}

		MainMenu.getInstance().show();

	}
}
