package by.jonline.module5.task4.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cave {

	private final int CAPACITY = 100;
	private List<Treasure> treasures = new ArrayList<Treasure>();

	public Cave() {
		generateTreasures();
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public void addTreasure(Treasure treasure) {
		if (treasures.size() < CAPACITY) {
			treasures.add(treasure);
		}
	}

	private void generateTreasures() {
		int treasureType, type;
		Random random = new Random();

		for (int i = 0; i < CAPACITY; i++) {
			Treasure treasure;
			treasureType = random.nextInt(2);

			if (treasureType == 0) {
				type = random.nextInt(2);

				CoinType coinType;
				if (type == 0) {
					coinType = CoinType.GOLD;
				} else {
					coinType= CoinType.SILVER;
				}

				treasure = new Coin(coinType);

			} else {
				type = random.nextInt(4);

				JewelType jewelType;
				switch (type) {
					case 0:
						jewelType = JewelType.DIAMOND; break;
					case 1:
						jewelType = JewelType.RUBY; break;
					case 2:
						jewelType = JewelType.SAPPHIRE; break;
					default:
						jewelType = JewelType.EMERALD;
				}

				treasure = new Jewel(jewelType);
			}

			treasures.add(treasure);
		}
	}

}
