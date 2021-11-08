package by.jonline.module5.task3;

/**
 * Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
 * выходных и праздничных днях.
 */
public class Main {

	public static void main(String[] args) {
		Calendar calendar = new Calendar(2021);

		View view = new View();
		view.printYear(calendar);
	}

}
