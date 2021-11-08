package by.jonline.module6.task3.view.action;

import by.jonline.module6.task3.entity.*;
import by.jonline.module6.task3.exception.ServerException;
import by.jonline.module6.task3.service.ClientServiceProvider;
import by.jonline.module6.task3.service.ServerInteractionService;
import by.jonline.module6.task3.view.ActionView;
import by.jonline.module6.task3.view.View;
import by.jonline.module6.task3.view.menu.MainMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateCaseActionView implements ActionView {
	private static ActionView instance;

	private ServerInteractionService serverInteractionService = ClientServiceProvider.getInstance().getServerInteractionService();
	private View view = View.getInstance();

	private CreateCaseActionView() throws IOException {}

	public static ActionView getInstance() throws IOException {
		if (instance == null) {
			instance = new CreateCaseActionView();
		}
		return instance;
	}
	@Override
	public void show() {
		Scanner reader = view.getReader();

		System.out.println("Введите фамилию студента");
		String surname = reader.nextLine();

		System.out.println("Введите имя студента");
		String name = reader.nextLine();

		System.out.println("Введите отчество студента");
		String patronymic = reader.nextLine();

		System.out.println("Введите адрес проживания студента");
		String address = reader.nextLine();

		System.out.println("Введите номер документа, удостоверяющего личность");
		String docId = reader.nextLine();

		System.out.println("Введите факультет: 1 - лечебное дело, 2 - стоматология, 3 - фармация");
		String facultyId;
		while (!(facultyId = reader.nextLine()).matches("[1-3]{1}")) {
			System.out.println("Неверный ввод данных");
		}

		String educationFormId;
		if (facultyId.equals("3")) {
			System.out.println("Введите форму обучения: 1 - очная, 2 - заочная");
			while (!(educationFormId = reader.nextLine()).matches("[1-2]{1}")) {
				System.out.println("Неверный ввод данных");
			}
		} else {
			educationFormId = "1";
		}

		System.out.println("Введите форму оплата: 1 - бюджет, 2 - внебюджет");
		String paymentTypeId;
		while (!(paymentTypeId = reader.nextLine()).matches("[1-2]{1}")) {
			System.out.println("Неверный ввод данных");
		};

		Student student = new Student(surname, name, patronymic);
		student.setAddress(address);
		student.setDocumentId(docId);

		Case caseObj = new Case();
		caseObj.setStudent(student);

		switch (facultyId) {
			case "1":
				caseObj.setFaculty(Faculty.GENERAL_MEDICINE);
				break;
			case "2":
				caseObj.setFaculty(Faculty.DENTYSTRY);
				break;
			case "3":
				caseObj.setFaculty(Faculty.FARMACY);
				break;
		}

		switch (educationFormId) {
			case "1":
				caseObj.setEducationForm(EducationForm.FULLTIME);
				break;
			case "2":
				caseObj.setEducationForm(EducationForm.PARTTIME);
				break;
		}

		switch (paymentTypeId) {
			case "1":
				caseObj.setPaymentType(PaymentType.FREE);
				break;
			case "2":
				caseObj.setPaymentType(PaymentType.PAID);
				break;
		}

		caseObj.setCreationDate(LocalDate.now());


		try {
			SaveObject saveObject = new SaveObject("new", caseObj);
			serverInteractionService.sendData(saveObject);

			System.out.println("Новые данные сохранены");

			MainMenu.getInstance().show();
		} catch (IOException | ClassNotFoundException e) {
			view.printError(e.getMessage());
		} catch (ServerException e) {
			view.printError("Возникла ошибка на сервере: " + e.getMessage());
		}

	}
}
