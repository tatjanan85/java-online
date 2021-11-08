package by.jonline.module4.part1.task1;

/**
 * Создайте класс by.jonline.module4.part1.task1.Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.
 */
public class Main {

	public static void main(String[] args) {
		Test1 test = new Test1(12, 13);

		test.printVars();
		System.out.println("Сумма = " + test.sum());
		System.out.println("Максимум = " + test.max());
	}
}
