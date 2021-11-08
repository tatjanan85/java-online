package by.jonline.module4.part1.task3;

/**
 * Создайте класс с именем by.jonline.module4.part1.task3.Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Иванов В.В.", 8);
		int[] marks1 = {9,9,8,8,7};
		student1.setMarks(marks1);

		Student student2 = new Student("Иванова В.В.", 9);
		int[] marks2 = {9,9,10,9,9};
		student2.setMarks(marks2);

		Student student3 = new Student("Сидоров В.В.", 9);
		int[] marks3 = {10,9,10,10,9};
		student3.setMarks(marks3);

		Student student4 = new Student("Сидорова В.В.", 9);
		int[] marks4 = {6,9,10,9,9};
		student4.setMarks(marks4);

		Student student5 = new Student("Смирнов В.В.", 9);
		int[] marks5 = {9,7,10,9,9};
		student5.setMarks(marks5);

		Student student6 = new Student("Смирнова В.В.", 9);
		int[] marks6 = {9,9,10,9,10};
		student6.setMarks(marks6);

		Student student7 = new Student("Котенко В.В.", 9);
		int[] marks7 = {10,10,10,9,9};
		student7.setMarks(marks7);

		Student student8 = new Student("Котенкова В.В.", 9);
		int[] marks8 = {9,9,5,9,9};
		student8.setMarks(marks8);

		Student student9 = new Student("Жарко В.В.", 9);
		int[] marks9 = {9,9,10,10,9};
		student9.setMarks(marks9);

		Student student10 = new Student("Жаркова В.В.", 9);
		int[] marks10 = {9,9,9,9,9};
		student10.setMarks(marks10);

		Student[] students = new Student[10];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;
		students[5] = student6;
		students[6] = student7;
		students[7] = student8;
		students[8] = student9;
		students[9] = student10;

		View view = new View();
		view.printAllStudents(students);
		view.printExcellentStudents(students);
	}
}
