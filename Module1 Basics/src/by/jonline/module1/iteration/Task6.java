package by.jonline.module1.iteration;

/**
 * Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 */
public class Task6 {
	public static void main(String[] args) {
		String alphabet = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮЮЯя";

		printCharsNumber(alphabet);
	}

	public static void printCharsNumber(String value) {
		for (int i = 0; i < value.length(); i++) {
			Character ch = value.charAt(i);
			System.out.printf("Символ %c имеет код %d\n", ch, (int)ch);
		}
	}

}
