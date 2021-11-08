package by.jonline.module4.part1.task3;

import by.jonline.module4.part1.task3.Student;

public class View {

	public void printAllStudents(Student[] students) {
		System.out.println("Список всех студентов:");
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}

	// вывод списка студентов-отличников
	public void printExcellentStudents(Student[] students) {
		System.out.println("Список студентов с оценками не ниже 9:");
		for (Student student : students) {
			if (student.isExcellent()) {
				System.out.println(student);
			}
		}
		System.out.println();
	}
}
