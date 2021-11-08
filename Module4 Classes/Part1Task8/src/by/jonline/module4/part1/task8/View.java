package by.jonline.module4.part1.task8;

import java.util.List;

public class View {

	// вывод всех покупателей
	public void printCustomers(List<Customer> customers) {
		for (int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i));
		}
	}
}
