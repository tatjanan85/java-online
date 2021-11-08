package by.jonline.module6.task1.view.impl;

import by.jonline.module6.task1.exception.AutorizationException;
import by.jonline.module6.task1.exception.InvalidFileUserFormatException;
import by.jonline.module6.task1.view.ActionView;
import by.jonline.module6.task1.view.View;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LoginView implements ActionView {

	private static LoginView instance;
	private View view = View.getInstance();

	private LoginView() {}

	public static LoginView getInstance() {
		if (instance == null) {
			instance = new LoginView();
		}
		return instance;
	}

	@Override
	public void show() {
		String login, password;
		Scanner reader = view.getReader();

		System.out.println("Введите логин и пароль");
		login = reader.next();
		password = reader.next();

		try {
			boolean result = view.getUserService().autorization(login, password);

			if (result) {
				MainMenu.getInstance().show();
			} else {
				System.out.println("Неверный логин и/или пароль");
				show();
			}
		} catch (InvalidFileUserFormatException | AutorizationException e) {
			view.printError(e.getMessage());
			show();
		} catch (IOException e) {
			view.printError("Ошибка ввода-вывода");
			show();
		} catch (NoSuchAlgorithmException e) {
			view.printError("Используется неизвестный алгоритм шифрования");
		}
	}

}
