package by.jonline.module4.part2.task4.logic;

import by.jonline.module4.part2.task4.entity.Account;
import by.jonline.module4.part2.task4.entity.Client;

import java.util.List;

public class ClientLogic {

	private AccountLogic accountLogic = new AccountLogic();

	// сумма по всем счетам
	public int sumOfAllAccounts(Client client) {
		int sum = 0;

		for (Account account : client.getAccounts()) {
			sum += account.getBalance();
		}
		return sum;
	}

	// сумма счётов с положительным балансом
	public int sumOfPositiveBalances(Client client) {
		int sum = 0;

		for (Account account : client.getAccounts()) {
			if (accountLogic.check(account)) {
				sum += account.getBalance();
			}
		}
		return sum;
	}

	// сумма счётов с отрицательным балансом
	public int sumOfNegativeBalances(Client client) {
		int sum = 0;
		for (Account account : client.getAccounts()) {
			if (!accountLogic.check(account)) {
				sum += account.getBalance();
			}
		}
		return sum;
	}

	// поиск счёта по номеру
	public Account findAccountByNumber(Client client, int id) {
		for (Account account : client.getAccounts()) {
			if (account.getId() == id)
				return account;
		}
		return null;
	}

	// сортировка счетов по балансу
	public List<Account> sortAccountsByBalance(Client client) {
		List<Account> accounts = client.getAccounts();

		for (int i = 0; i < accounts.size() - 1; i++) {
			for (int j = 0; j < accounts.size() - 1 - i; j++) {
				if (accounts.get(j).getBalance() > accounts.get(j + 1).getBalance()) {
					Account temp = accounts.get(j);
					accounts.set(j, accounts.get(j + 1));
					accounts.set(j + 1, temp);
				}
			}
		}

		return accounts;
	}


}
