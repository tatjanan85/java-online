package by.jonline.module4.part2.task4.view;

import by.jonline.module4.part2.task4.entity.Account;
import by.jonline.module4.part2.task4.entity.Client;
import by.jonline.module4.part2.task4.logic.ClientLogic;

public class ClientView {
	private ClientLogic clientLogic = new ClientLogic();

	public void printAllAccounts(Client client) {
		System.out.println("Клиент " + client.getName());
		for (Account account : client.getAccounts())
			System.out.println(account);
		System.out.println("-----------------------------");
	}

	public void printAccountsByBalance(Client client) {
		System.out.println("Сортировка счетов по балансу:");
		System.out.println("Клиент " + client.getName());

		for (Account account : clientLogic.sortAccountsByBalance(client)) {
			System.out.println(account);
		}

		System.out.println("-----------------------------");
	}

	public void printSumOfAllAccounts(Client client) {
		System.out.println("Сумма на всех счетах = " +
				clientLogic.sumOfAllAccounts(client));
	}

	public void printSumOfPositiveBalances (Client client) {
		System.out.println("Сумма на счетах с положительным балансом равна " +
				clientLogic.sumOfPositiveBalances(client));
	}

	public void printSumOfNegativeBalances (Client client) {
		System.out.println("Сумма на счетах с отрицательным балансом равна " +
				clientLogic.sumOfNegativeBalances(client));
	}


}
