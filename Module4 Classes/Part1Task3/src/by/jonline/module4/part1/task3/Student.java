package by.jonline.module4.part1.task3;

import java.util.Arrays;
import java.util.Objects;

public class Student {

	private String name;
	private int group;
	private int[] marks;

	public Student() {

	}

	public Student(String name, int group) {
		this.name = name;
		this.group = group;
	}

	public boolean isExcellent() {
		for (int mark : marks) {
			if (mark < 9)
				return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public int getGroup() {
		return group;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;
		Student student = (Student) o;
		return group == student.group && Objects.equals(name, student.name) && Arrays.equals(marks, student.marks);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(name, group);
		result = 31 * result + Arrays.hashCode(marks);
		return result;
	}

	@Override
	public String toString() {
		return "Студент {" +
				"ФИО = '" + name + '\'' +
				", группа = " + group +
				", оценки = " + Arrays.toString(marks) +
				'}';
	}

}
