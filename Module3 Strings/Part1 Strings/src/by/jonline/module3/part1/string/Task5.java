package by.jonline.module3.part1.string;

/**
 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”
 */
public class Task5 {

	public static void main(String[] args) {
		String str = "Подсчитать, сколько раз среди символов заданной строки встречается буква “а”";
		System.out.println(str);

		System.out.println("Количество букв \"а\" = " + countSymbol(str, 'а'));
	}

	public static int countSymbol(String str, char symbol) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == symbol)
				count++;
		}
		return count;
	}
}
