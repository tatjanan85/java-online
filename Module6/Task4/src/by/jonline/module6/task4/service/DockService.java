package by.jonline.module6.task4.service;

import by.jonline.module6.task4.entity.Dock;
import by.jonline.module6.task4.entity.Port;
import by.jonline.module6.task4.entity.Ship;
import by.jonline.module6.task4.view.View;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DockService {

	private static DockService instance;
	private final int TIMEOUT = 5000;
	private View view = View.getInstance();

	private DockService() {}

	public static DockService getInstance() {
		if (instance == null) {
			instance = new DockService();
		}
		return instance;
	}

	public int loading(Ship ship, Dock dock) throws InterruptedException {
		TimeUnit.SECONDS.sleep(new Random().nextInt(3));
		synchronized (this) {
			if (ship.isEmpty()) {

				long startTime = System.currentTimeMillis();
				long endTime = startTime;
				boolean timeOut = false;

				while (Port.getInstance().getStorage() < ship.getCapacity() ) {
					wait(100);
					endTime = System.currentTimeMillis();

					if (endTime - startTime > TIMEOUT) {
						timeOut = true;
						break;
					}
				}

				if (!timeOut) {
					ship.setEmpty(false);
					view.printMessage("Корабль №" + ship.getId() +
							" загружен у причала №" + dock.getId());
					notify();
					return -ship.getCapacity();
				} else {
					view.printMessage("Время ожидания превышено. Корабль №" + ship.getId() +
							" покинул причал №" + dock.getId() + " незагруженным");
					return 0;
				}

			} else {

				long startTime = System.currentTimeMillis();
				long endTime = startTime;
				boolean timeOut = false;

				while (Port.getInstance().getCapacity() - Port.getInstance().getStorage() <
						ship.getCapacity() ) {

					wait(100);
					endTime = System.currentTimeMillis();

					if (endTime - startTime > TIMEOUT) {
						timeOut = true;
						break;
					}
				}

				if (!timeOut) {
					ship.setEmpty(true);
					view.printMessage("Корабль №" + ship.getId() +
							" разгружен у причала №" + dock.getId());
					notify();

					return ship.getCapacity();
				} else {
					view.printMessage("Время ожидания превышено. Корабль №" + ship.getId() +
							" покинул причал №" + dock.getId() + " неразгруженным");

					return 0;
				}
			}
		}
	}
}
