package by.jonline.module4.part1.task6;

/**
 * Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 */
public class Main {

	public static void main(String[] args) {

		Time time = new Time(12, 12, 12);
		System.out.println("Установленное время:");
		System.out.println(time);

		//изменение заданного количества часов
		System.out.println("\n+4 часа:");
		time.plusHours(4);
		System.out.println(time);

		System.out.println("\n-17 часов:");
		time.minusHours(17);
		System.out.println(time);

		System.out.println("\n+48 часов:");
		time.plusHours(48);
		System.out.println(time);

		//изменение заданного количества минут
		System.out.println("\n+4 минуты:");
		time.plusMinutes(4);
		System.out.println(time);

		System.out.println("\n-62 минуты:");
		time.minusMinutes(62);
		System.out.println(time);

		System.out.println("\n+121 минуту:");
		time.plusMinutes(121);
		System.out.println(time);

		//изменение заданного количества секунд
		System.out.println("\n+48 секунд:");
		time.plusSeconds(48);
		System.out.println(time);

		System.out.println("\n-13 секунд:");
		time.minusSeconds(13);
		System.out.println(time);

		System.out.println("\n-3654 секунды:");
		time.minusSeconds(3654);
		System.out.println(time);

	}
}
