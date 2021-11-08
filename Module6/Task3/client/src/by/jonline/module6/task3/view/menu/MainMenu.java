package by.jonline.module6.task3.view.menu;

import by.jonline.module6.task3.entity.Role;
import by.jonline.module6.task3.exception.ServerException;
import by.jonline.module6.task3.service.ClientServiceProvider;
import by.jonline.module6.task3.service.ServerInteractionService;
import by.jonline.module6.task3.view.Menu;
import by.jonline.module6.task3.view.View;
import by.jonline.module6.task3.view.action.CreateCaseActionView;
import by.jonline.module6.task3.view.action.EditCaseActionView;

import java.io.IOException;

public class MainMenu implements Menu {
	private static Menu instance;

	private View view = View.getInstance();
	private ServerInteractionService serverInteractionService = ClientServiceProvider.getInstance().getServerInteractionService();

	private MainMenu() throws IOException {}

	public static Menu getInstance() throws IOException {
		if (instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}

	@Override
	public void show() {
		System.out.println("Выберите действие:");
		System.out.println("1 - выход из программы");
		System.out.println("2 - поиск");

		int lastItem = 2;

		if (serverInteractionService.getCurrentUser().getRole() == Role.ADMIN) {
			System.out.println("3 - редактирование");
			System.out.println("4 - новое дело");
			lastItem = 4;
		}

		int choice = view.getUserChoice(lastItem);
		chooseAction(choice);
	}

	@Override
	public void chooseAction(int choice) {
		try {
			switch (choice) {
				case 1:
					Boolean result = (Boolean) serverInteractionService.sendData("exit");
					if (result) {
						System.exit(0);
					}
				case 2:

						SearchMenu.getInstance().show();

					break;
				case 3:
					EditCaseActionView.getInstance().show();
					break;
				case 4:
					CreateCaseActionView.getInstance().show();
					break;
			}
		} catch (IOException | ClassNotFoundException e) {
			view.printError(e.getMessage());
		} catch (ServerException e) {
			view.printError("Возникла ошибка на сервере: " + e.getMessage());
		}
	}
}
