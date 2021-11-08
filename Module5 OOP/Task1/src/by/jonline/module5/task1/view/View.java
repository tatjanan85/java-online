package by.jonline.module5.task1.view;

import by.jonline.module5.task1.entity.TextFile;

public class View {

	public void printTextFileToConsole(TextFile file) {
		System.out.println(file.getContent());
	}
}
