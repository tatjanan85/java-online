package by.jonline.module5.task2;

/**
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
 * нескольких товаров.
 */
public class Main {

	public static void main(String[] args) {
		Payment payment = new Payment(1);

		payment.addProduct(new Payment.Product(1, "Товар1", 100));
		payment.addProduct(new Payment.Product(2, "Товар2", 200));
		payment.addProduct(new Payment.Product(3, "Товар3", 300));

		View view = new View();
		view.printPaymentDetails(payment);
		view.printPaymentSum(payment);
	}
}
