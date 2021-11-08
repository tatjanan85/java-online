package by.jonline.module1.linear_program;

import static java.lang.Math.*;

/**
 * Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * (𝑏 + √(𝑏2 + 4𝑎𝑐))/ (2𝑎) − 𝑎^3𝑐 + 𝑏^(−2)
 */
public class Task2 {

    public static void main(String[] args) {

        double a = 4;
        double b = 8;
        double c = 2;

        double z = doFunction(a, b, c);
        System.out.println("Значение функции z = " + round(z * 100.0) / 100.0);
    }

    public static double doFunction(double a, double b, double c) {
        return (b + sqrt(b * b + 4 * a * c)) / (2 * a) - pow(b, -2);
    }
}

