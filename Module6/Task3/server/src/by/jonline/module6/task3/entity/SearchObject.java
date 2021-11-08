package by.jonline.module6.task3.entity;

import java.io.Serializable;
import java.util.Objects;

public class SearchObject implements Serializable {
	private String type;
	private Object data;

	public SearchObject() {}

	public SearchObject(String type, Object data) {
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public Object getData() {
		return data;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SearchObject that = (SearchObject) o;
		return Objects.equals(type, that.type) && Objects.equals(data, that.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, data);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"type='" + type + '\'' +
				", data=" + data +
				'}';
	}
}
