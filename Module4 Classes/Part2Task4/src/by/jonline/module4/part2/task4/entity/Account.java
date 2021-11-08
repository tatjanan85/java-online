package by.jonline.module4.part2.task4.entity;

import java.util.Objects;

public class Account {

	private int id;
	private int balance;
	private boolean blocked = false;

	public Account(int id) {
		this.id = id;
		System.out.println("Счёт создан");
	}

	public int getId() {
		return id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Account)) return false;
		Account that = (Account) o;
		return id == that.id && balance == that.balance && blocked == that.blocked;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, balance, blocked);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"id=" + id +
				", balance=" + balance +
				", blocked=" + blocked +
				'}';
	}
}
