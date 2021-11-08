package by.jonline.module6.task3.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Case implements Serializable {

	private int id;
	private Student student;
	private Faculty faculty;
	private EducationForm educationForm;
	private PaymentType paymentType;
	private LocalDate creationDate;

	public Case() {

	}

	public Case(int id, Student student) {
		this.id = id;
		this.student = student;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public void setEducationForm(EducationForm educationForm) {
		this.educationForm = educationForm;
	}

	public EducationForm getEducationForm() {
		return educationForm;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Case aCase = (Case) o;
		return id == aCase.id && Objects.equals(student, aCase.student) &&
				faculty == aCase.faculty && educationForm == aCase.educationForm &&
				paymentType == aCase.paymentType &&
				Objects.equals(creationDate, aCase.creationDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, student, faculty, educationForm, paymentType, creationDate);
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return " Дело {" +
				"№" + id +
				"; " + student +
				"; факультет: " + faculty +
				"; форма обучения: " + educationForm +
				"; форма оплаты: " + paymentType +
				"; дата создания: " + creationDate.format(formatter) +
				'}';
	}
}
