package by.jonline.module1.linear_program;

import static java.lang.Math.*;

/**
 * Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * (𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦) /  (𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦) ∗ 𝑡𝑔 𝑥𝑦
 */
public class Task3 {

    public static void main(String[] args) {

        double x = 90;
        double y = 100;

        double z = doFunction(x, y);
        System.out.println("Значение функции z = " + round(z * 100.0) / 100.0);
    }

    public static double doFunction(double x, double y) {
        return (sin(x) + cos (y)) / (cos(x) - sin(y)) * tan (x * y) ;
    }
}
