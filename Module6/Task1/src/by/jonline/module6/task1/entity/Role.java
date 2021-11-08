package by.jonline.module6.task1.entity;

public enum Role {
	ADMIN("администратор"),
	READER("читатель");

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
