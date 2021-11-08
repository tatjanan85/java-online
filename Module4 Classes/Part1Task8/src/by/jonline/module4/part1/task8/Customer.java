package by.jonline.module4.part1.task8;

import java.util.Objects;

public class Customer {

	private int id;
	private String name;
	private String surname;
	private String patronymic;
	private String address;
	private long creditCard;
	private long bankAccount;

	public Customer(int id, String name, String surname, String patronymic) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(long creditCard) {
		this.creditCard = creditCard;
	}

	public long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(long bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Customer)) return false;
		Customer customer = (Customer) o;
		return id == customer.id && creditCard == customer.creditCard &&
				bankAccount == customer.bankAccount &&
				Objects.equals(name, customer.name) &&
				Objects.equals(surname, customer.surname) &&
				Objects.equals(patronymic, customer.patronymic) &&
				Objects.equals(address, customer.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, surname, patronymic, address, creditCard, bankAccount);
	}

	@Override
	public String toString() {
		return "Покупатель {" +
				"id=" + id +
				", Фамилия='" + name + '\'' +
				", Имя='" + surname + '\'' +
				", Отчество='" + patronymic + '\'' +
				", Адрес='" + address + '\'' +
				", Кредитная карта=" + creditCard +
				", Банковский счёт=" + bankAccount +
				'}';
	}
}
