package by.jonline.module3.part1.string;

/**
 * В строке вставить после каждого символа 'a' символ 'b'
 */
public class Task2 {
	public static void main(String[] args) {
		String str = "В строке встaвить после кaждого символa 'a' символ 'b'";
		System.out.println(str);

		System.out.println(insertSymbol(str, 'b', 'a'));
	}

	public static String insertSymbol(String str, char symbol, char after) {
		String searchStr = Character.toString(after);
		String insertedStr = searchStr + Character.toString(symbol);

		str = str.replaceAll(searchStr, insertedStr);
		return str;
	}
}
