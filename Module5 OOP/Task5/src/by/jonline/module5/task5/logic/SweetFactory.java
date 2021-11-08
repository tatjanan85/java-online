package by.jonline.module5.task5.logic;

import by.jonline.module5.task5.entity.*;

import java.util.Random;

public class SweetFactory {

	public static Sweet createSweet(int type){
		Sweet sweet = null;
		Random random = new Random();

		switch(type) {
			case 0:
				sweet = createCandy(random.nextInt(3));
				break;
			case 1:
				sweet = createWaffle(random.nextInt(2));
				break;
			case 2:
				sweet = createChocolate(random.nextInt(3));
				break;
		}
		return sweet;
	}

	private static Candy createCandy(int type) {
		Candy candy = null;

		switch(type) {
			case 0:
				candy = new Candy(CandyType.SUGAR);
				break;
			case 1:
				candy = new Candy(CandyType.TOFFEE);
				break;
			case 2:
				candy = new Candy(CandyType.CHOCOLATE);
				break;
		}
		return candy;
	}

	private static Waffle createWaffle(int type) {
		Waffle waffle = null;

		switch(type) {
			case 0:
				waffle = new Waffle(WaffleType.CREAMY);
				break;
			case 1:
				waffle = new Waffle(WaffleType.CHOCOLATE);
				break;
		}
		return waffle;
	}

	private static Chocolate createChocolate(int type) {
		Chocolate chocolate = null;

		switch(type) {
			case 0:
				chocolate = new Chocolate(ChocolateType.MILK);
				break;
			case 1:
				chocolate = new Chocolate(ChocolateType.RAISIN);
				break;
			case 2:
				chocolate = new Chocolate(ChocolateType.NUTTY);
				break;
		}
		return chocolate;
	}

}
