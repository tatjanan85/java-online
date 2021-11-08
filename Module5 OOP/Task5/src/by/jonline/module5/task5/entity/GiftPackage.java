package by.jonline.module5.task5.entity;

public enum GiftPackage {
	STANDART(10), LUX(20);

	private int price;

	GiftPackage(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}


}
