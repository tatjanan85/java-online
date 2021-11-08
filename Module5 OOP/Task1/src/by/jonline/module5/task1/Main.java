package by.jonline.module5.task1;

import by.jonline.module5.task1.entity.Directory;
import by.jonline.module5.task1.entity.TextFile;
import by.jonline.module5.task1.view.View;

/**
 * Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */
public class Main {

	public static void main(String[] args) {

		Directory dir = new Directory("Main");

		TextFile file = new TextFile("New File");
		file.setContent("Some text 1");
		file.addContent("Some text 2");

		dir.addFile(file);

		View view = new View();
		view.printTextFileToConsole(file);

		dir.deleteFile(file);
	}
}
