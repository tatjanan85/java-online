package by.jonline.module5.task4.logic;

import by.jonline.module5.task4.entity.Treasure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaveLogic {

	public List<Treasure> findMaxTreasure(List<Treasure> treasures) {
		List<Treasure> result = new ArrayList<Treasure>();
		int max = 0;

		for (Treasure treasure : treasures) {
			if (treasure.getWorth() > max) {
				max = treasure.getWorth();
			}
		}

		for (Treasure treasure : treasures) {
			if (treasure.getWorth() == max) {
				result.add(treasure);
			}
		}

		return  result;
	}

	public List<Treasure> findTreasuresBySum(List<Treasure> treasures, int search) {
		List<Treasure> result = new ArrayList<Treasure>();

		for (int i = 0; i < treasures.size(); i++) {
			if (treasures.get(i).getWorth() == search) {
				result.add(treasures.get(i));
				return result;
			}
		}

		for (int i = 0; i < treasures.size(); i++) {
			if (checkSum(i + 1, treasures.get(i).getWorth(), search, treasures, result)) {
				result.add(treasures.get(i));
				return result;
			}
		}

		return result;
	}

	private boolean checkSum(int index, int sum, int search, List<Treasure> treasures, List<Treasure> result) {
		if (index == treasures.size()) return false;

		for (int i = index; i < treasures.size(); i++) {
			if (sum + treasures.get(i).getWorth() == search) {
				result.add(treasures.get(i));
				return true;
			}
		}


		if (checkSum(index + 1, sum + treasures.get(index).getWorth(), search,treasures, result)) {
			result.add(treasures.get(index));
			return true;
		} else {
			return false;
		}
	}
}
