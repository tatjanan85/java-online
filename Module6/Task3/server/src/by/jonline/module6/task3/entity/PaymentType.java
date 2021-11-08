package by.jonline.module6.task3.entity;

public enum PaymentType {
	FREE ("бюджет"),
	PAID ("внебюджет");

	private String name;

	PaymentType(String name) {
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
