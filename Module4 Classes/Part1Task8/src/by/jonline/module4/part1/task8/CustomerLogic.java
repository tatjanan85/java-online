package by.jonline.module4.part1.task8;

import java.util.List;

public class CustomerLogic {

	private View view = new View();

	//сортировка покупателей в алфавитном порядке
	private void sortInAlphabet(List<Customer> customers) {
		
		for (int i = 0; i < customers.size() - 1; i++) {
			for (int j = 0; j < customers.size() - 1 - i; j++) {
				String fullname1 = 	customers.get(j).getName() +
									customers.get(j).getSurname() +
									customers.get(j).getPatronymic();
				String fullname2 = 	customers.get(j + 1).getName() +
									customers.get(j + 1).getSurname() +
									customers.get(j + 1).getPatronymic();

				if (fullname1.compareTo(fullname2) > 0) {
					Customer temp = customers.get(j);
					customers.set(j, customers.get(j + 1));
					customers.set(j + 1, temp);
				}
			}
		}
	}



	// печать покупателей с кредитными картами в заданном диапазоне
	private void printCustomersWithCreditCard(List<Customer> customers, int from, int to) {
		boolean notFound = true;

		if (to >= from) {
			for (int i = 0; i < customers.size(); i++) {
				if (customers.get(i).getCreditCard() <= to && customers.get(i).getCreditCard() >= from) {
					System.out.println(customers.get(i));
					notFound = false;
				}
			}

			if (notFound) {
				System.out.println("Данные не найдены");
			}
		} else {
			System.out.println("Неверно указан диапазон");
		}
	}

	// выбор действия
	public void chooseAction(int value, List<Customer> customers) {

		switch (value) {
			case 1:
				view.printCustomers(customers);
				break;
			case 2:
				sortInAlphabet(customers);
				System.out.println("\nСортировка в алфавитном порядке:");
				view.printCustomers(customers);
				break;
			case 3:
				//hard code
				int from = 91120000;
				int to = 91120002;

				System.out.println("Результаты поиска:");
				printCustomersWithCreditCard(customers, from, to);
				break;
			case 4:
				System.out.println("Выход из приложения");
				break;
			default:
				System.out.println("Неверно задано дайствие");
		}

		System.out.println("-------------------------------------------------------------");
	}


}
