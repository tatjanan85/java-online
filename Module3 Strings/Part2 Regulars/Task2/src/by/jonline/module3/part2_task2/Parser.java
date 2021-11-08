package by.jonline.module3.part2_task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	public boolean parse(String xml) {
		//паттерн для поиска пары открывающий/закрывающий тег или тега без тела
		Pattern pattern = Pattern.compile("<([a-zA-Z0-9]+) *[a-z =\"0-9]*>(.*?)</\\1>|<([a-zA-Z0-9]+)>");
		Matcher matcher = pattern.matcher(xml);

		boolean result = false;

		while (matcher.find()) {
			if (matcher.group(3) != null) {
				System.out.println("Тег без тела " + matcher.group(3));
			} else {
				result = true;

				System.out.println("Открывающий тег " + matcher.group(1));
				if (!parse(matcher.group(2))) {
					System.out.println("Содержимое тега " + matcher.group(1) + ": " + matcher.group(2));
				}
				System.out.println("Закрывающий тег " + matcher.group(1));
			}
		}

		return result;
	}
}
