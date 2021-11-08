package by.jonline.module6.task3.entity;

public enum EducationForm {

	FULLTIME ("очная"),
	PARTTIME ("заочная");

	private String name;

	EducationForm(String name) {
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
