package by.jonline.module6.task4.entity;

import by.jonline.module6.task4.service.DockService;
import by.jonline.module6.task4.view.View;

import java.util.Objects;

public class Ship extends Thread {

	private Port port;
	private int capacity;
	private boolean isEmpty;

	public Ship(Port port, int capacity) {
		this.port = port;
		this.capacity = capacity;
	}

	@Override
	public void run() {
		Dock dock = null;

		dock = port.getDock(this);

		try {
			int amount = DockService.getInstance().loading(this, dock);
			port.setStorage(port.getStorage() + amount);
		} catch (InterruptedException e) {
			View.getInstance().printMessage(e.getMessage());
		}

		if (dock != null) {
			port.leaveDock(this, dock);
		}

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ship ship = (Ship) o;
		return capacity == ship.capacity && isEmpty == ship.isEmpty && Objects.equals(port, ship.port);
	}

	@Override
	public int hashCode() {
		return Objects.hash(port, capacity, isEmpty);
	}

	@Override
	public String toString() {
		return "Корабль [" +
				"№ = " + getId() +
				", грузоподъёмность = " + getCapacity() +
				", " + (isEmpty ? "пуст" : "загружен") +
				']';
	}
}
