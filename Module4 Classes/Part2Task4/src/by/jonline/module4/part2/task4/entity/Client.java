package by.jonline.module4.part2.task4.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
	private static int counter;
	private int id;
	private String name;
	private List<Account> accounts = new ArrayList<Account>();

	public Client(String name) {
		this.id = ++counter;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Client)) return false;
		Client client = (Client) o;
		return id == client.id && Objects.equals(name, client.name) && Objects.equals(accounts, client.accounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, accounts);
	}

	@Override
	public String toString() {
		return "Клиент {" +
				"id=" + id +
				", ФИО='" + name + '\'' +
				'}';
	}


}
