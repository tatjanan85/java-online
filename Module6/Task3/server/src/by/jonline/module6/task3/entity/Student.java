package by.jonline.module6.task3.entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {

	private String name;
	private String surname;
	private String patronymic;
	private String address;
	private String documentId;

	public Student() {
	}

	public Student(String surname, String name, String patronymic) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(patronymic, student.patronymic) && Objects.equals(address, student.address) && Objects.equals(documentId, student.documentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname, patronymic, address, documentId);
	}

	@Override
	public String toString() {
		return "[" +
				"ФИО: " + surname + " " +
				name + " " + patronymic +
				"; адрес: " + address +
				"; номер документа: " + documentId +
				']';
	}
}
