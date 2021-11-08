package by.jonline.module1.linear_program;

import static java.lang.Math.*;
/**
 * Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
 * принадлежит закрашенной области, и false — в противном случае
 */
public class Task6 {

    public static void main(String[] args) {
        int x = -3;
        int y = 0;

        System.out.println("Координата закрашенной области? - " + check(x, y));
    }

    public static boolean check(int x, int y) {
        if ((y > 0) && (y <= 4) && abs(x) < 3)
            return true;
        if ((y > -4) && (y <= 0) && abs(x) < 5)
            return true;

        return false;
    }
}
