package masa.java.homework.task2;

import java.util.Arrays;

/**
 * Создайте переменную массива с 20 целыми числами от пользователя и выведите
 * следующее:
 * - количество положительных чисел
 * - количество отрицательных чисел
 * - количество нечетных чисел
 * - количество четных чисел количество нулей
 */

public class Solution {
    public static void main(String[] args) {
        int[] myArray = new int[20];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 100) - 50;
        }
        System.out.println("MyArray: " + Arrays.toString(myArray));

        int numberOfPositives = 0;
        int numberOfNegatives = 0;
        int numberOfZeroes = 0;
        int numberOfOdds = 0; // Нечетные
        int numberOfEvens = 0; // Четные

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > 0)
                numberOfPositives++;
            else if (myArray[i] < 0)
                numberOfNegatives++;
            else
                numberOfZeroes++;

            if (myArray[i] % 2 == 0)
                numberOfEvens++;
            else
                numberOfOdds++;
        }
        System.out.println("Number of positives: " + numberOfPositives);
        System.out.println("Number of negatives: " + numberOfNegatives);
        System.out.println("Number of zeroes: " + numberOfZeroes);
        System.out.println("Number of evens: " + numberOfEvens);
        System.out.println("Number of odds: " + numberOfOdds);
    }
}
