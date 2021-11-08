package by.jonline.module4.part1.task2;

/**
 * Создйте класс by.jonline.module4.part1.task2.Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
 * конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
 * класса.
 */
public class Main {
	public static void main(String[] args) {
		Test2 test1 = new Test2();
		test1.setVar2(3);

		Test2 test2 = new Test2(1, 2);

		System.out.println("Значения переменных объекта test1: " +
				test1.getVar1() + ", " + test1.getVar2());
		System.out.println("Значения переменных объекта test2: " +
				test2.getVar1() + ", " + test2.getVar2());

	}
}
