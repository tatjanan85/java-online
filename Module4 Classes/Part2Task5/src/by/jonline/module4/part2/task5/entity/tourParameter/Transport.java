package by.jonline.module4.part2.task5.entity.tourParameter;

public enum Transport {
	PLAINE("авиа"),
	TRAIN("поезд"),
	BUS("автобус"),
	SHIP("корабль");

	String name;

	Transport(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
