package by.jonline.module6.task3.entity;

public enum Role {

	ADMIN("администратор"),
	USER("пользователь");

	private String name;

	Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
