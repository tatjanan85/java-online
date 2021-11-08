package by.jonline.module4.part2.task5.entity.tourParameter;

public enum Type {
	HOLIDAY("отдых"),
	EXCURCION("экскурсионный"),
	SHOPPING("шоппинг"),
	TREATMENT("лечение"),
	CRUISE("круиз"),
	SPORT("спортивный");

	String name;

	Type(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
