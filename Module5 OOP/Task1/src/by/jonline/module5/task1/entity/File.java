package by.jonline.module5.task1.entity;

import java.util.Objects;

public class File {

	private String name;

	public File() {
		this.name = "New File";
	}

	public File(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof File)) return false;
		File file = (File) o;
		return Objects.equals(name, file.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"name='" + name + '\'' +
				'}';
	}
}
