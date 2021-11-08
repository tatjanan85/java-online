package by.jonline.module4.part2.task5;

/**
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
 * позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 */
public class Main {

	public static void main(String[] args) {

		Counter counter1 = new Counter();

		System.out.println("Состояние счётчика, созданного конструктором по умолчанию:");
		System.out.println(counter1.getState());

		System.out.println("Увеличение счетчика. Диапазон значений [" + Counter.getMinValue() + ", " +
							Counter.getMaxValue() + "]:");
		System.out.println(counter1.incrementAndGet());

		System.out.println("Уменьшение счетчика. Диапазон значений [" + Counter.getMinValue() + ", " +
				Counter.getMaxValue() + "]:");
		System.out.println(counter1.decrementAndGet());

		Counter counter2 = new Counter(30);

		System.out.println("Состояние счётчика с заданным начальным значением:");
		System.out.println(counter2.getState());

		System.out.println("Увеличение счетчика. Диапазон значений [" + Counter.getMinValue() + ", " +
				Counter.getMaxValue() + "]:");
		System.out.println(counter2.incrementAndGet());

		System.out.println("Уменьшение счетчика. Диапазон значений [" + Counter.getMinValue() + ", " +
				Counter.getMaxValue() + "]:");
		System.out.println(counter2.decrementAndGet());
	}
}
