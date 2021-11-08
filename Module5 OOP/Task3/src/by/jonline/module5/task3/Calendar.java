package by.jonline.module5.task3;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class Calendar {

	private int year;
	private List<Day> days = new ArrayList<Day>();

	public Calendar(int year) {
		this.year = year;
		calendarGenerate(year);
	}

	public Day getDay(int day, int month) {
		for(Day d : days) {
			if (d.getDay() == day && d.getMonth() == month) {
				return d;
			}
		}
		return null;
	}

	public List<Day> getDays() {
		return days;
	}

	public int getYear() {
		return year;
	}

	public class Day {
		private int day;
		private int month;

		private boolean holiday;
		private boolean dayOff;

		public Day(int day, int month) {
			this.day = day;
			this.month = month;
		}

		public void setHoliday(boolean holiday) {
			this.holiday = holiday;
		}

		public boolean isHoliday() {
			return holiday;
		}

		public void setDayOff(boolean dayOff) {
			this.dayOff = dayOff;
		}

		public boolean isDayOff() {
			return dayOff;
		}

		public int getDay() {
			return day;
		}

		public int getMonth() {
			return month;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Day)) return false;
			Day day1 = (Day) o;
			return day == day1.day && month == day1.month && holiday == day1.holiday && dayOff == day1.dayOff;
		}

		@Override
		public int hashCode() {
			return Objects.hash(day, month, holiday, dayOff);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " {" +
					"day=" + day +
					", month=" + month +
					", holiday=" + holiday +
					", dayOff=" + dayOff +
					'}';
		}
	}

	private void calendarGenerate(int year){
		GregorianCalendar calendar = new GregorianCalendar();
		int lastMonthDay;

		for (int i = 1; i <= 12; i++) {
			switch (i) {
				case 4:
				case 6:
				case 9:
				case 11:
					lastMonthDay = 30;
					break;
				case 2:
					if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
						lastMonthDay = 29;
					} else {
						lastMonthDay = 28;
					}
				default:
					lastMonthDay = 31;
			}


			for (int j = 1; j <= lastMonthDay; j++) {
				Day day = new Day(j, i);
				//установим все субботы и воскресенья как нерабочие дни
				calendar.set(year, i, j);
				if (calendar.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY ||
						calendar.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SUNDAY){
					day.setDayOff(true);
				}
				days.add(day);
			}
		}

		// установим 1 января, 8 марта, 1 мая, 9 мая как праздники и выходные
		Day day;
		day = getDay(1, 1);
		day.setHoliday(true);
		day.setDayOff(true);


		day = getDay(8, 3);
		day.setHoliday(true);
		day.setDayOff(true);

		day = getDay(1, 5);
		day.setHoliday(true);
		day.setDayOff(true);

		day = getDay(9, 5);
		day.setHoliday(true);
		day.setDayOff(true);

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Calendar)) return false;
		Calendar calendar = (Calendar) o;
		return year == calendar.year && Objects.equals(days, calendar.days);
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, days);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"year=" + year +
				", days=" + days +
				'}';
	}
}
