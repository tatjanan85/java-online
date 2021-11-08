package by.jonline.module4.part1.task6;

public class Time {

	private int hours;
	private int minutes;
	private int seconds;

	public Time() {
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}

	public Time(int hours, int minutes, int seconds) {
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	public final void setHours(int hours) {
		if (hours > 0 && hours < 24) {
			this.hours = hours;
		} else {
			this.hours = 0;
		}
	}

	public final void setMinutes(int minutes) {
		if (minutes > 0 && minutes < 60) {
			this.minutes = minutes;
		} else {
			this.minutes = 0;
		}
	}

	public final void setSeconds(int seconds) {
		if (seconds > 0 && seconds < 60) {
			this.seconds = seconds;
		} else {
			this.seconds = 0;
		}
	}

	public void plusHours(int hours) {
		this.hours = (this.hours + hours) % 24;
	}

	public void minusHours(int hours) {
		if (this.hours >= hours) {
			this.hours -= hours;
		} else {
			this.hours = 24 - hours % 24 + this.hours;
		}
	}

	public void plusMinutes(int minutes) {
		plusHours((this.minutes + minutes) / 60);
		this.minutes = (this.minutes + minutes) % 60;
	}

	public void minusMinutes(int minutes) {
		int hours = minutes / 60;
		minusHours(hours);
		minutes = minutes % 60;

		if (this.minutes >= minutes) {
			this.minutes -= minutes;
		} else {
			minusHours(1);
			this.minutes = 60 - minutes % 60 + this.minutes;
		}
	}

	public void plusSeconds(int seconds) {
		plusMinutes((this.seconds + seconds) / 60);
		this.seconds = (this.seconds + seconds) % 60;
	}

	public void minusSeconds(int seconds) {
		int minutes = seconds / 60;
		minusMinutes(minutes);
		seconds = seconds % 60;

		if (this.seconds >= seconds) {
			this.seconds -= seconds;
		} else {
			minusMinutes(1);
			this.seconds = 60 - seconds % 60 + this.seconds;
		}
	}

	@Override
	public String toString() {
		return "Время: " +
				hours + " ч. " +
				minutes + " мин. " +
				seconds +" с. ";
	}
}
