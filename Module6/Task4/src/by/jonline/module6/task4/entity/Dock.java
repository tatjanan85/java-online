package by.jonline.module6.task4.entity;

import java.util.Objects;

public class Dock {

	private int id;
	private volatile boolean isBusy;

	public Dock(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(boolean busy) {
		isBusy = busy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dock dock = (Dock) o;
		return id == dock.id && isBusy == dock.isBusy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isBusy);
	}

	@Override
	public String toString() {
		return "Причал [" +
				"№ = " + getId() +
				']';
	}
}
