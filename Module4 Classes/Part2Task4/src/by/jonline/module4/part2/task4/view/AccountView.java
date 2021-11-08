package by.jonline.module4.part2.task4.view;

import by.jonline.module4.part2.task4.entity.Account;

public class AccountView {

	public void printBlockingInfo(int id) {

		System.out.println("Счёт №" + id);
		System.out.println("Счёт заблокирован");
		System.out.println("-----------------------------");
	}

	public void printUnblockingInfo(int id) {

		System.out.println("Счёт №" + id);
		System.out.println("Счёт разблокирован");
		System.out.println("-----------------------------");
	}

	public void printBlockedError() {
		System.out.println("Операция невозможна, счёт заблокирован");
	}

	public void printBalance(Account account) {
		System.out.println("Счёт №" + account.getId());
		System.out.println("Текущий баланс " + account.getBalance());
	}

	public void printWithdrawInfo(Account account, int value) {
		System.out.println("Со счёта снято " + value);
	}

	public void printTopUpInfo(Account account, int value) {
		System.out.println("Счёт пополнен на " + value);
	}
}
