package by.jonline.module4.part2.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private String model;
	private Engine engine;
	private List<Wheel> wheels = new ArrayList<Wheel>();
	private boolean isRunning = false;

	public Car(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
		System.out.println("Двигатель установлен");
		System.out.println("---------------------------");
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		System.out.println("Попытка установить колеса");
		if (wheels.size() == 4) {
			this.wheels = wheels;
			System.out.println("Колеса установлены");
		} else {
			System.out.println("Колеса не установлены. У автомобиля должно быть 4 колеса!");
		}
		System.out.println("---------------------------");
	}

	public void addWheel(Wheel wheel) {
		System.out.println("Попытка установить колесо");
		if (wheels.size() < 4) {
			wheels.add(wheel);
			System.out.println("Колесо установлено");
		} else {
			System.out.println("Колесо не установлено. Нельзя добавить автомобилю 5-е колесо");
		}
		System.out.println("---------------------------");
	}

	public void go() {
		System.out.println("Попытка завести автомобиль");
		if (check()) {
			if (!isRunning) {
				engine.start();
				isRunning = true;
				System.out.println("Автомобиль едет!");
			} else {
				System.out.println("Автомобиль уже едет!");
			}
		} else {
			System.out.println("Автомобиль не готов к поездке!");
		}
		System.out.println("---------------------------");
	}

	public void stop() {
		System.out.println("Попытка остановить автомобиль");
		if (isRunning) {
			engine.stop();
			isRunning = false;
			System.out.println("Автомобиль остановлен");
		} else {
			System.out.println("Автомобиль на стоянке");
		}
		System.out.println("---------------------------");
	}

	public void fillUp() {
		System.out.println("Попытка заправить автомобиль");
		if (check()) {
			if (isRunning) {
				System.out.println("Автомобиль в движении нельзя заправить! Остановите автомобиль!");
			} else {
				System.out.println("Автомобиль заправлен");
			}
		} else {
			System.out.println("Автомобиль не готов к заправке!");
		}
		System.out.println("---------------------------");
	}

	public boolean check() {
		if (engine == null) {
			System.out.println("Проблема с двигателем!");
			return false;
		}
		if (wheels.size() < 4) {
			System.out.println("Проблема с колёсами! Должно быть 4");
			return false;
		}
		return true;
	}

	public void printModel() {
		System.out.println("Марка автомобиля " + getModel());
		System.out.println("---------------------------");
	}
}
