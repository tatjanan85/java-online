package by.jonline.module5.task3;

public class View {

	public void printMonth(Calendar calendar, int month) {
		for (Calendar.Day day : calendar.getDays()) {
			if (day.getMonth() == month) {
				System.out.printf("%02d.%02d.%4d ", day.getDay(), day.getMonth(), calendar.getYear());

				if (day.isDayOff()) {
					System.out.print("выходной ");
				}

				if (day.isHoliday()) {
					System.out.print("праздник ");
				}
				System.out.println();
			}
		}
	}

	public void printYear(Calendar calendar) {
		for (Calendar.Day day : calendar.getDays()) {
			System.out.printf("%02d.%02d.%4d ", day.getDay(), day.getMonth(), calendar.getYear());

			if (day.isDayOff()) {
				System.out.print("выходной ");
			}

			if (day.isHoliday()) {
				System.out.print("праздник ");
			}
			System.out.println();
		}
	}
}
