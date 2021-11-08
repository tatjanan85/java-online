package by.jonline.module6.task3.view.menu;

import by.jonline.module6.task3.entity.Case;
import by.jonline.module6.task3.entity.Faculty;
import by.jonline.module6.task3.entity.SearchObject;
import by.jonline.module6.task3.exception.ServerException;
import by.jonline.module6.task3.service.ClientServiceProvider;
import by.jonline.module6.task3.service.ServerInteractionService;
import by.jonline.module6.task3.view.Menu;
import by.jonline.module6.task3.view.View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchMenu implements Menu {
	private static Menu instance;
	private View view = View.getInstance();
	private ServerInteractionService serverInteractionService = ClientServiceProvider.getInstance().getServerInteractionService();

	private SearchMenu() throws IOException {
	}

	public static Menu getInstance() throws IOException {
		if (instance == null) {
			instance = new SearchMenu();
		}
		return instance;
	}

	@Override
	public void show() {
		System.out.println("Выберите действие:");
		System.out.println("1 - поиск дела по id");
		System.out.println("2 - поиск дел по факультету");
		System.out.println("3 - поиск дел по фамилии");
		System.out.println("4 - выйти в главное меню");

		int lastItem = 4;
		int choice = view.getUserChoice(lastItem);
		chooseAction(choice);
	}

	@Override
	public void chooseAction(int choice) {
		List<Case> result;
		SearchObject searchObject;
		Scanner reader = view.getReader();

		try {
			switch (choice) {
				case 1:
					System.out.println("Введите id");
					String id;

					while (!(id = reader.nextLine()).matches("[1-9]{1}[0-9]*")) {
						System.out.println("Неверный ввод данных");
					}

					searchObject = new SearchObject("id", Integer.valueOf(id));

					result = (List<Case>) serverInteractionService.sendData(searchObject);

					view.printCases(result);
					show();
					break;
				case 2:

					System.out.println("Введите факультет: 1 - лечебное дело, 2 - стоматология, 3 - фармация");
					String facultyId;
					while (!(facultyId = reader.nextLine()).matches("[1-3]{1}")) {
						System.out.println("Неверный ввод данных");
					}

					Faculty faculty;
					if (facultyId.equals("1")) {
						faculty = Faculty.GENERAL_MEDICINE;
					} else if (facultyId.equals("2")) {
						faculty = Faculty.DENTYSTRY;
					} else {
						faculty = Faculty.FARMACY;
					}

					searchObject = new SearchObject("faculty", faculty);

					result = (List<Case>) serverInteractionService.sendData(searchObject);

					view.printCases(result);
					show();
					break;
				case 3:

					System.out.println("Введите фамилию для поиска:");
					String surname = reader.nextLine();

					searchObject = new SearchObject("surname", surname);

					result = (List<Case>) serverInteractionService.sendData(searchObject);

					view.printCases(result);
					show();
					break;
				case 4:
					MainMenu.getInstance().show();
			}
		} catch (IOException | ClassNotFoundException e) {
			view.printError(e.getMessage());
		} catch (ServerException e) {
			view.printError("Возникла ошибка на сервере: " + e.getMessage());
		}
	}
}