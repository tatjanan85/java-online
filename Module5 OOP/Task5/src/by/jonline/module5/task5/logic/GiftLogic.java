package by.jonline.module5.task5.logic;

import by.jonline.module5.task5.entity.Gift;
import by.jonline.module5.task5.entity.GiftPackage;
import by.jonline.module5.task5.entity.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiftLogic {

	public Gift createGift(int quantity, GiftPackage giftPackage) {
		List<Sweet> sweets = createRandomSweetList(quantity);

		Gift gift = new Gift(giftPackage);
		gift.setSweets(sweets);
		return gift;
	}

	public List<Sweet> createRandomSweetList(int quantity) {
		List<Sweet> sweets = new ArrayList<Sweet>();
		Random random = new Random();
		int number, type;

		for (int i = 0; i < quantity; i++) {
			number = random.nextInt(100);

			if (number % 2 == 0) {
				type = 0;
			} else if (number % 3 == 0) {
				type = 2;
			} else {
				type = 1;
			}

			sweets.add(SweetFactory.createSweet(type));
		}

		return sweets;
	}
}
