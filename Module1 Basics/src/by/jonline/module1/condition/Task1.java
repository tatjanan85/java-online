package by.jonline.module1.condition;

import java.util.Scanner;

/**
 * 1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
 * он прямоугольным.
 */
public class Task1 {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int angle1;
        System.out.println("Введите значение 1-го угла");
        while (!sc.hasNextInt()) {
            System.out.println("Введите значение 1-го угла");
            sc.next();
        }
        angle1 = sc.nextInt();

        int angle2;
        System.out.println("Введите значение 2-го угла");
        while (!sc.hasNextInt()) {
            System.out.println("Введите значение 2-го угла");
            sc.next();
        }
        angle2 = sc.nextInt();

        if (checkTriangle(angle1, angle2)) {
            System.out.println("Треугольник существует");

            String isRecTriangle = checkRecTriangle(angle1, angle2) ? "да" : "нет";
            System.out.println("Он прямоугольный? - " + isRecTriangle);
        } else {
            System.out.println("Треугольник не существует");
        }

    }

    // проверка на то, существует ли треугольник с заданными углами
    public static boolean checkTriangle(int angle1, int angle2) {
        return angle1 > 0 && angle2 > 0 && angle1 + angle2 < 180;
    }

    // проверка, является ли треугольник прямоугольным
    public static boolean checkRecTriangle(int angle1, int angle2) {
        if (!checkTriangle(angle1, angle2)) {
            return false;
        }

        if ((angle1 == 90) || (angle2 == 90) || (angle1 + angle2 == 90)) {
            return true;
        }

        return false;
    }
}
