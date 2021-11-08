package by.jonline.module6.task4.entity;

import by.jonline.module6.task4.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Port {

	private static Port instance;

	private final int capacity = 150;
	private final int DOCK_AMOUNT = 6;
	private Semaphore semaphore = new Semaphore(DOCK_AMOUNT, true);
	private List<Dock> docks = new ArrayList<Dock>();
	private volatile int storage = 50;
	private View view = View.getInstance();

	private Port() {
		for (int i = 0; i < DOCK_AMOUNT; i++) {
			docks.add(new Dock(i + 1));
		}
	}

	public static Port getInstance() {
		if (instance == null) {
			instance = new Port();
		}
		return instance;
	}

	public int getCapacity() {
		return capacity;
	}

	public Dock getDock(Ship ship) {
		try {
			semaphore.acquire();

			for (Dock dock : docks) {
				if (! dock.isBusy()) {
					dock.setBusy(true);
					view.printMessage("Корабль №" + ship.getId() + " у причала " + dock.getId());

					return dock;
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		return null;
	}

	public void leaveDock(Ship ship, Dock dock) {
		dock.setBusy(false);
		view.printMessage("На складе " + getStorage() + " контейнеров");
		view.printMessage("Корабль №" + ship.getId() + " покинул причал " + dock.getId());
		semaphore.release();
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
}
