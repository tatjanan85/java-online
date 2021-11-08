package by.jonline.module6.task1.entity;

import java.util.List;
import java.util.Objects;

public class Mail {
	private String fromUser;
	private List<User> toUsers;
	private String subject;
	private String message;
	private String attachmentPath;

	public Mail(String from, List<User> to, String subject) {
		this.fromUser = from;
		this.toUsers = to;
		this.subject = subject;
	}

	public String getFrom() {
		return fromUser;
	}

	public void setFrom(String from) {
		this.fromUser = from;
	}

	public List<User> getToUsers() {
		return toUsers;
	}

	public void setToUsers(List<User> to) {
		this.toUsers = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mail mail = (Mail) o;
		return Objects.equals(fromUser, mail.fromUser) && Objects.equals(toUsers, mail.toUsers) &&
				Objects.equals(subject, mail.subject) && Objects.equals(message, mail.message) &&
				Objects.equals(attachmentPath, mail.attachmentPath);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fromUser, toUsers, subject, message, attachmentPath);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"from='" + fromUser + '\'' +
				", to='" + toUsers + '\'' +
				", subject='" + subject + '\'' +
				", message='" + message + '\'' +
				", attachment='" + attachmentPath + '\'' +
				'}';
	}
}
