package by.jonline.module4.part2.task2;

import by.jonline.module4.part2.task2.entity.Car;
import by.jonline.module4.part2.task2.entity.Engine;
import by.jonline.module4.part2.task2.entity.Wheel;

/**
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля
 */
public class Main {

	public static void main(String[] args) {
		Car car = new Car("Audi");
		car.go();
		car.fillUp();

		car.setEngine(new Engine());
		car.addWheel(new Wheel());
		car.addWheel(new Wheel());
		car.addWheel(new Wheel());
		car.addWheel(new Wheel());
		car.addWheel(new Wheel());

		car.go();
		car.fillUp();

		car.stop();
		car.fillUp();

		car.printModel();
	}
}
