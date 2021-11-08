package by.jonline.module4.part2.task4;

import by.jonline.module4.part2.task4.entity.Account;
import by.jonline.module4.part2.task4.entity.Client;
import by.jonline.module4.part2.task4.logic.AccountLogic;
import by.jonline.module4.part2.task4.logic.ClientLogic;
import by.jonline.module4.part2.task4.view.ClientView;

import java.util.List;

/**
 * Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
 * счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Main {

	public static void main(String[] args) {
		Client client = new Client("Иванов Петр Алексеевич");
		System.out.println("Клиент " + client.getName());

		client.addAccount(new Account(1));
		client.addAccount(new Account(2));
		client.addAccount(new Account(3));

		ClientLogic clientLogic = new ClientLogic();

		Account account1 = clientLogic.findAccountByNumber(client, 1);

		AccountLogic accountLogic = new AccountLogic();

		accountLogic.topUp(account1, 50);
		accountLogic.block(account1);
		accountLogic.withdraw(account1, 100);
		accountLogic.unblock(account1);
		accountLogic.withdraw(account1,100);

		Account account2 = clientLogic.findAccountByNumber(client, 2);
		accountLogic.topUp(account2, 200);

		Account account3 = clientLogic.findAccountByNumber(client, 3);
		accountLogic.topUp(account3, 100);

		ClientView clientView = new ClientView();

		clientView.printAllAccounts(client);
		clientView.printAccountsByBalance(client);

		clientView.printSumOfAllAccounts(client);
		clientView.printSumOfPositiveBalances(client);
		clientView.printSumOfNegativeBalances(client);

	}
}
