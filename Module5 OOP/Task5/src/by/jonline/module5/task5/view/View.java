package by.jonline.module5.task5.view;

import by.jonline.module5.task5.entity.Gift;
import by.jonline.module5.task5.entity.GiftPackage;
import by.jonline.module5.task5.entity.Sweet;
import by.jonline.module5.task5.logic.GiftLogic;
import by.jonline.module5.task5.logic.SweetFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {

	private GiftLogic giftLogic = new GiftLogic();

	public void printSweets(List<Sweet> sweets) {
		if (sweets.size() > 0) {
			Set<Sweet> set = new TreeSet<>(sweets);
			int number = 1;
			for (Sweet sweet : set) {
				System.out.println(number++ + ". " + sweet + " - " + Collections.frequency(sweets, sweet) + " шт.");
			}

		} else {
			System.out.println("в подарке нет конфет");
		}
	}



	public void userChoice(int choice, int quantity) {
		Gift gift = null;

		if (checkInput(choice)) {
			switch (choice) {
				case 1:
					System.out.printf("Подарок в стандартной упаковке на %d наименований:\n", quantity);
					gift = giftLogic.createGift(quantity, GiftPackage.STANDART);
					break;
				case 2:
					System.out.printf("Подарок в люкс-упаковке на %d наименований:\n", quantity);
					gift = giftLogic.createGift(quantity, GiftPackage.LUX);
					break;
			}

			printSweets(gift.getSweets());
		} else {
			System.out.println("Данные введены неверно");
		}
	}

	// проверка данных вводимых пользователем
	private boolean checkInput(int choice) {
		Pattern pattern = Pattern.compile("[1-2]{1}");
		Matcher matcher = pattern.matcher(String.valueOf(choice));

		return matcher.matches();
	}
}
