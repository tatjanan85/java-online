package by.jonline.module6.task2.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Note {
	private int id;
	private String theme;
	private LocalDate creationDate;
	private String email;
	private String message;

	public Note(String theme, String message, String email) {

		this.theme = theme;
		this.message = message;
		this.email = email;
		this.creationDate = LocalDate.now();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Note note = (Note) o;
		return id == note.id &&
				Objects.equals(theme, note.theme) &&
				Objects.equals(creationDate, note.creationDate) &&
				Objects.equals(email, note.email) &&
				Objects.equals(message, note.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, theme, creationDate, email, message);
	}

	@Override
	public String toString() {
		return "Заметка [" +
				"id = " + id +
				", тема = " + theme +
				", дата создания = " + creationDate +
				", e-mail = " + email +
				", содержание = " + message +
				"]";
	}
}
