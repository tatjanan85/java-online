package by.jonline.module1.linear_program;

import static java.lang.Math.*;
/**
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
 * дробную и целую части числа и вывести полученное значение числа
 */
public class Task4 {

    public static void main(String[] args) {
        double r = 123.654;
        System.out.println("Новое значение " + doFunction(r));
    }

    /**
     *  1. Выделяется целая часть
     *  2. Выделется дробная часть
     *  3. Выделенные части соединяются в строку
     *  4. Строка парсится как число
     */
    public static double doFunction(double r) {
        int intPart = (int) floor(r);
        int decPart = (int) (r * 1000 % 1000);
        return Double.parseDouble(decPart + "." + intPart);
    }
}


