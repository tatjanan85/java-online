package by.jonline.module4.part2.task4.logic;

import by.jonline.module4.part2.task4.entity.Account;
import by.jonline.module4.part2.task4.view.AccountView;

public class AccountLogic {

	private AccountView view = new AccountView();

	// блокировка счёта
	public void block(Account account) {
		account.setBlocked(true);

		view.printBlockingInfo(account.getId());
	}

	// разблокировка счёта
	public void unblock(Account account) {
		account.setBlocked(false);

		view.printUnblockingInfo(account.getId());
	}

	// снятие со счёта
	public void withdraw(Account account, int value) {
		if (!account.isBlocked()) {
			view.printBalance(account);
			account.setBalance(account.getBalance() - value);
			view.printWithdrawInfo(account, value);
		} else {
			System.out.println("Снятие со счёта невозможно, счёт заблокирован!");
		}
		System.out.println("-----------------------------");
	}

	//пополнение счёта
	public void topUp(Account account, int value) {
		if (!account.isBlocked()) {
			view.printBalance(account);
			account.setBalance(account.getBalance() + value);
			view.printTopUpInfo(account, value);
		} else {
			System.out.println("Пополнение счёта невозможно, счёт заблокирован!");
		}
		System.out.println("-----------------------------");
	}

	// проверка баланса, положительный - true, иначе false
	public boolean check(Account account) {
		if (account.getBalance() > 0)
			return true;
		return false;
	}
}
