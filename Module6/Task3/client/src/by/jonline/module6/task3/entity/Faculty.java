package by.jonline.module6.task3.entity;

public enum Faculty {
	GENERAL_MEDICINE ("лечебное дело"),
	FARMACY ("фармация"),
	DENTYSTRY ("стоматология");

	private String name;

	Faculty(String name) {
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
