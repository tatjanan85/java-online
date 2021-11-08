package by.jonline.module6.task4.service;

import by.jonline.module6.task4.entity.Port;
import by.jonline.module6.task4.entity.Ship;
import by.jonline.module6.task4.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipService {

	private static ShipService instance;

	private final int MIN_CAPACITY = 5;
	private final int MAX_CAPACITY = 20;

	private ShipService() {}

	public static ShipService getInstance() {
		if (instance == null) {
			instance = new ShipService();
		}
		return instance;
	}

	public List<Ship> createRandomShips(int number, Port port) {
		List<Ship> ships = new ArrayList<>();
		Random random = new Random();
		int capacity;
		boolean isEmpty;
		Ship ship;

		for (int i = 0; i < number; i++) {
			capacity = random.nextInt(MAX_CAPACITY - MIN_CAPACITY + 1) + MIN_CAPACITY;
			ship = new Ship(port, capacity);

			isEmpty = random.nextBoolean();
			if (isEmpty){
				ship.setEmpty(true);
			}

			ships.add(ship);
		}

		return ships;
	}

	public void runShips(List<Ship> ships) {
		View.getInstance().printMessage("На складе " + Port.getInstance().getStorage() + " контейнеров");
		for (Ship ship : ships) {
			ship.start();
		}
	}
}
