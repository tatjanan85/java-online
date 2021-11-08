package by.jonline.module4.part1.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Создать класс by.jonline.module4.part1.task8.Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа by.jonline.module4.part1.task8.Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Класс by.jonline.module4.part1.task8.Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class Main {

	public static void main(String[] args) {

		Customer c1 = new Customer(1, "Сидоров", "Иван", "Петрович");
		c1.setAddress("Витебск");
		c1.setBankAccount(91120000);
		c1.setCreditCard(91120000);

		Customer c2 = new Customer(2, "Иванов", "Иван", "Ильич");
		c2.setAddress("Минск");
		c2.setBankAccount(91120001);
		c2.setCreditCard(91120001);

		Customer c3 = new Customer(3, "Шарова", "Ирина", "Алексеевна");
		c3.setAddress("Витебск");
		c3.setBankAccount(91120002);
		c3.setCreditCard(91120002);

		Customer c4 = new Customer(4, "Сидоров", "Андрей", "Петрович");
		c4.setAddress("Гродно");
		c4.setBankAccount(91120010);
		c4.setCreditCard(91120010);

		Customer c5 = new Customer(5, "Андреев", "Петр", "Сергеевич");
		c5.setAddress("Орша");
		c5.setBankAccount(91120005);
		c5.setCreditCard(91120005);

		//Customer[] customers = { c1, c2, c3, c4, c5 };
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);

		CustomerLogic ca = new CustomerLogic();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int value;

		do {
			System.out.println("Выберите действие:");
			System.out.println("1 - вывести данные всех покупателй");
			System.out.println("2 - вывести данные в алфавитном порядке");
			System.out.println("3 - вывести данные покупателей с кредитной картой в заданном диапазоне");
			System.out.println("4 - выход");

			while (!scanner.hasNextInt()) {
				System.out.println("Неверно задано дайствие");
				scanner.nextLine();
			}
			value = scanner.nextInt();
			ca.chooseAction(value, customers);

		} while (value != 4);

	}
}
