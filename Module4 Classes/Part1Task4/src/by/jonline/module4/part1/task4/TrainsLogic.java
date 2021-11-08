package by.jonline.module4.part1.task4;

public class TrainsLogic {

	// сортировка по номеру поезда
	public Train[] sortByNumber(Train[] trains) {
		Train[] sortedTrains = new Train[trains.length];
		sortedTrains = trains.clone();

		for (int i = 0; i < sortedTrains.length - 1; i++) {
			for (int j = 0; j < sortedTrains.length - 1 - i; j++) {
				if (sortedTrains[j].getNumber() > sortedTrains[j + 1].getNumber()) {
					Train temp = sortedTrains[j];
					sortedTrains[j] = sortedTrains[j + 1];
					sortedTrains[j + 1] = temp;
				}
			}
		}
		return sortedTrains;
	}

	// сортировка по пункту назначения, при равенстве по времени отправления
	public Train[] sortByDestination(Train[] trains) {
		Train[] sortedTrains = new Train[trains.length];
		sortedTrains = trains.clone();

		for (int i = 0; i < sortedTrains.length - 1; i++) {
			for (int j = 0; j < sortedTrains.length - 1 - i; j++) {
				if (sortedTrains[j].getDestination().compareTo(sortedTrains[j + 1].getDestination()) > 0) {
					Train temp = sortedTrains[j];
					sortedTrains[j] = sortedTrains[j + 1];
					sortedTrains[j + 1] = temp;
				} else if (sortedTrains[j].getDestination().compareTo(sortedTrains[j + 1].getDestination()) == 0) {
					if (sortedTrains[j].getDepartureTime().isAfter(sortedTrains[j + 1].getDepartureTime())) {
						Train temp = sortedTrains[j];
						sortedTrains[j] = sortedTrains[j + 1];
						sortedTrains[j + 1] = temp;
					}
				}

			}
		}
		return sortedTrains;
	}

	public Train findTrainByNumber(Train[] trains, int number) {
		for (Train train : trains) {
			if (train.getNumber() == number) {
				return train;
			}
		}
		return null;
	}



}
