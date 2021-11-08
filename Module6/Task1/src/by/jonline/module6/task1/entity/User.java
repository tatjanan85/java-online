package by.jonline.module6.task1.entity;

import java.util.Objects;

public class User {
	private String login;
	private String password;
	private Role role;
	private String email;

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * используем только логин для проверки,
	 * т.к. двух пользователей с одинаковым логином быть не должно
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(login, user.login);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public String toString() {
		return "Пользователь {" +
				"логин ='" + login + '\'' +
				", роль =" + role +
				", e-mail =" + email +
				'}';
	}
}
