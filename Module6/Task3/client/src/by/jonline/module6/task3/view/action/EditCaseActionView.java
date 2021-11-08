package by.jonline.module6.task3.view.action;

import by.jonline.module6.task3.entity.*;
import by.jonline.module6.task3.exception.ServerException;
import by.jonline.module6.task3.service.ClientServiceProvider;
import by.jonline.module6.task3.service.ServerInteractionService;
import by.jonline.module6.task3.view.ActionView;
import by.jonline.module6.task3.view.View;
import by.jonline.module6.task3.view.menu.MainMenu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EditCaseActionView implements ActionView {
	private static ActionView instance;
	private ServerInteractionService serverInteractionService = ClientServiceProvider.getInstance().getServerInteractionService();
	private View view = View.getInstance();

	private EditCaseActionView() throws IOException {}

	public static ActionView getInstance() throws IOException {
		if (instance == null) {
			instance = new EditCaseActionView();
		}
		return instance;
	}

	@Override
	public void show() {
		Scanner reader = view.getReader();

		System.out.println("Введите id дела, которое нужно отредактировать");
		String id;

		while (!(id = reader.nextLine()).matches("[1-9]{1}[0-9]*")) {
			System.out.println("Неверный ввод данных");
		}

		Case currentCase = null;

		try {
			SearchObject searchObject = new SearchObject("id", Integer.valueOf(id));

			List<Case> result = (List<Case>) serverInteractionService.sendData(searchObject);

			if (result.size() == 0) {
				System.out.println("Дело с таким id не найдено");
				MainMenu.getInstance().show();
				return;
			}

			view.printCases(result);
			currentCase = result.get(0);

			String editedField;
			do {
				System.out.println("Введите номер поля, которое нужно отредактировать");
				System.out.println("1 - фамилия, 2 - имя, 3 - отчество, 4 - адрес, 5 - номер документа ");
				System.out.println("6 - факультет, 7 - форма обучения, 8 - форма оплаты, 9 - сохранить изменения");

				while (!(editedField = reader.nextLine()).matches("[1-9]{1}")) {
					System.out.println("Неверный ввод данных");
				}

				switch (editedField) {
					case "1":
						System.out.println("Введите фамилию студента");
						System.out.println("Текущее значение: " + currentCase.getStudent().getSurname());
						String surname = reader.nextLine();

						currentCase.getStudent().setSurname(surname);
						break;
					case "2":
						System.out.println("Введите имя студента");
						System.out.println("Текущее значение: " + currentCase.getStudent().getName());
						String name = reader.nextLine();

						currentCase.getStudent().setName(name);
						break;
					case "3":
						System.out.println("Введите отчество студента");
						System.out.println("Текущее значение: " + currentCase.getStudent().getPatronymic());
						String patronymic = reader.nextLine();

						currentCase.getStudent().setPatronymic(patronymic);
						break;
					case "4":
						System.out.println("Введите адрес проживания студента");
						System.out.println("Текущее значение: " + currentCase.getStudent().getAddress());
						String address = reader.nextLine();

						currentCase.getStudent().setAddress(address);
						break;
					case "5":
						System.out.println("Введите номер документа, удостоверяющего личность");
						System.out.println("Текущее значение: " + currentCase.getStudent().getDocumentId());
						String docId = reader.nextLine();

						currentCase.getStudent().setDocumentId(docId);
						break;
					case "6":
						System.out.println("Введите факультет: 1 - лечебное дело, 2 - стоматология, 3 - фармация");
						System.out.println("Текущее значение: " + currentCase.getFaculty());

						String facultyId;
						while (!(facultyId = reader.nextLine()).matches("[1-3]{1}")) {
							System.out.println("Неверный ввод данных");
						}

						switch (facultyId) {
							case "1":
								currentCase.setFaculty(Faculty.GENERAL_MEDICINE);
								break;
							case "2":
								currentCase.setFaculty(Faculty.DENTYSTRY);
								break;
							case "3":
								currentCase.setFaculty(Faculty.FARMACY);
								break;
						}

						break;
					case "7":
						String educationFormId;

						Faculty faculty = result.get(0).getFaculty();
						if (faculty.equals(Faculty.FARMACY)) {
							System.out.println("Введите форму обучения: 1 - очная, 2 - заочная");
							System.out.println("Текущее значение: " + currentCase.getEducationForm());

							while (!(educationFormId = reader.nextLine()).matches("[1-2]{1}")) {
								System.out.println("Неверный ввод данных");
							}

							switch (educationFormId) {
								case "1":
									currentCase.setEducationForm(EducationForm.FULLTIME);
									break;
								case "2":
									currentCase.setEducationForm(EducationForm.PARTTIME);
									break;
							}

						} else {
							System.out.println("На факультете: " + faculty +" существует только одна форма обучения: очная. ");
							System.out.println("Изменить данные невозможно");
						}

						break;
					case "8":
						System.out.println("Введите форму оплаты: 1 - бюджет, 2 - внебюджет");
						System.out.println("Текущее значение: " + currentCase.getPaymentType());
						String paymentTypeId;

						while (!(paymentTypeId = reader.nextLine()).matches("[1-2]{1}")) {
							System.out.println("Неверный ввод данных");
						}

						switch (paymentTypeId) {
							case "1":
								currentCase.setPaymentType(PaymentType.FREE);
								break;
							case "2":
								currentCase.setPaymentType(PaymentType.PAID);
								break;
						}
						break;
				}
			} while(!editedField.equals("9"));

			SaveObject saveObject = new SaveObject("modify", currentCase);
			serverInteractionService.sendData(saveObject);

			System.out.println("Изменения сохранены");
			MainMenu.getInstance().show();

		} catch (IOException | ClassNotFoundException e) {
			view.printError(e.getMessage());
		} catch (ServerException e) {
			view.printError("Возникла ошибка на сервере: " + e.getMessage());
		}

	}
}
