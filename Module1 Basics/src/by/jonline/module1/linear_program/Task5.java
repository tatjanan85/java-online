package by.jonline.module1.linear_program;

/**
 * Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
 * данное значение длительности в часах, минутах и секундах в следующей форме:
 * ННч ММмин SSc.
 */
public class Task5 {

    public static void main(String[] args) {

        long seconds = 5225L;
        System.out.println("Длительность = " + secondsToTime(seconds));
    }

    public static String secondsToTime(long seconds) {
        int hours = (int) (seconds / (60 * 60));
        int minutes = (int) ((seconds - hours * 60 * 60) / 60);
        int sec = (int) (seconds - hours * 60 * 60 - minutes * 60);

        return String.format("%2d ч %2d мин %2d с", hours, minutes, sec);
    }
}
