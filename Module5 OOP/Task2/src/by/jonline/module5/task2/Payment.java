package by.jonline.module5.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {

	private int id;
	private List<Product> products;

	public Payment() {
		products = new ArrayList<Product>();
	}

	public Payment(int id) {
		this();
		this.id = id;
	}

	public static class Product {
		private int id;
		private String title;
		private int price;

		public Product() {
		}

		public Product(int id, String title, int price) {
			this.id = id;
			this.title = title;
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Product)) return false;
			Product product = (Product) o;
			return id == product.id && price == product.price && Objects.equals(title, product.title);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, title, price);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " {" +
					"id=" + id +
					", title='" + title + '\'' +
					", price=" + price +
					'}';
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public int getSum() {
		int sum = 0;

		for (Product product : products) {
			sum += product.getPrice();
		}
		return sum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Payment)) return false;
		Payment payment = (Payment) o;
		return id == payment.id && Objects.equals(products, payment.products);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, products);
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", products=" + products +
				'}';
	}
}
