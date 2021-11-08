package by.jonline.module5.task5.entity;

import java.util.ArrayList;
import java.util.List;

public class Gift {

	private List<Sweet> sweets = new ArrayList<Sweet>();
	private GiftPackage giftPackage;

	public Gift(GiftPackage giftPackage) {
		this.giftPackage = giftPackage;
	}

	public List<Sweet> getSweets() {
		return sweets;
	}

	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}
}
