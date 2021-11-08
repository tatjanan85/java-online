package by.jonline.module1.linear_program;

/**
 * Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 */
public class Task1 {

    public static void main(String[] args) {

        double a = 2;
        double b = 3;
        double c = 1;

        double z = doFunction(a, b, c);
        System.out.println("Значение функции z = " + z);
    }

    public static double doFunction(double a, double b, double c) {
        return ((a - 3) * b / 2) + c;
    }
}
