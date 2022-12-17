package io.rienel;

import java.util.Objects;

/**
 * TODO ArMotozov
 *
 * @since 12/17/2022
 */
public class PersonJava {
	private String name;
	private String surname;
	private Integer age;

	public PersonJava(String name, String surname, Integer age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PersonJava(");
		sb.append("name='").append(name).append('\'');
		sb.append(", surname='").append(surname).append('\'');
		sb.append(", age=").append(age);
		sb.append(')');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PersonJava that = (PersonJava)o;

		if (!Objects.equals(name, that.name)) return false;
		if (!Objects.equals(surname, that.surname)) return false;
		return Objects.equals(age, that.age);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (age != null ? age.hashCode() : 0);
		return result;
	}
}
