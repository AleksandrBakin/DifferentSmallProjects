package masa.java.homework.rectangle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Напишите программу для печати площади двух прямоугольников со сторонами (4,5) и (5,8) соответственно.
 * Создать класс с именем «Rectangle» с методом «Area», который печатает площадь.
 */

public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(12.5,8.0);
        rectangle1.area();
        Rectangle rectangle2 = new Rectangle();
        rectangle2.area();
    }

    public static class Rectangle {
        double length;
        double height;

        public Rectangle (double length, double height) {
            this.length = length;
            this.height = height;
        }

        public Rectangle () {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter rectangle length:");
                this.length = Double.parseDouble(reader.readLine());
                System.out.println("Enter rectangle height:");
                this.height = Double.parseDouble(reader.readLine());;
            } catch (Exception e) {
                System.out.println("Sorry. Your input is incorrect...");
            }
            this.length = 0.0;
            this.height = 0.0;
        }

        public double area () {
            double result = this.length*this.height;
            System.out.printf(Locale.ENGLISH,
                    "Rectangle %f x %f area is %f",this.length,this.height,result);
            return result;
        }

    }
}