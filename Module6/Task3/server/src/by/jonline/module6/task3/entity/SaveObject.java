package by.jonline.module6.task3.entity;

import java.io.Serializable;
import java.util.Objects;

public class SaveObject implements Serializable {
	private String type;
	private Case caseObj;

	public SaveObject() {
	}

	public SaveObject(String type, Case caseObj) {
		this.type = type;
		this.caseObj = caseObj;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Case getCase() {
		return caseObj;
	}

	public void setCaseObj(Case caseObj) {
		this.caseObj = caseObj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SaveObject that = (SaveObject) o;
		return Objects.equals(type, that.type) && Objects.equals(caseObj, that.caseObj);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, caseObj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"type='" + type + '\'' +
				", caseObj=" + caseObj +
				'}';
	}
}
