package by.jonline.module6.task3.view.action;

import by.jonline.module6.task3.exception.ServerException;
import by.jonline.module6.task3.service.*;
import by.jonline.module6.task3.view.ActionView;
import by.jonline.module6.task3.view.View;
import by.jonline.module6.task3.view.menu.MainMenu;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LoginActionView implements ActionView {
	private static ActionView instance;

	private ServerInteractionService serverInteractionService = ClientServiceProvider.getInstance().getServerInteractionService();
	private View view = View.getInstance();

	private LoginActionView() throws IOException {}

	public static ActionView getInstance() throws IOException {
		if (instance == null) {
			instance = new LoginActionView();
		}
		return instance;
	}

	@Override
	public void show() {
		Scanner reader = view.getReader();

		System.out.println("Введите логин и пароль:");
		String login = reader.next();
		String password = reader.next();

		try {
			boolean result = serverInteractionService.sendLoginData(login, password);

			if (result) {
				MainMenu.getInstance().show();
			} else {
				System.out.println("Неверный логин и/или пароль");
				show();
			}
		} catch (IOException | NoSuchAlgorithmException | ClassNotFoundException e) {
			view.printError(e.getMessage());
			show();
		} catch (ServerException e) {
			view.printError("Возникла ошибка на сервере: " + e.getMessage());
		}
	}
}
