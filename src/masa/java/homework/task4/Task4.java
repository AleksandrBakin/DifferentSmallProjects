package masa.java.homework.task4;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Напишите программу, которая находит сумму и произведение всех элементов
 * массива.
 */

public class Task4 {
    public static void main(String[] args) {
        // int[] basicArray = { 61, 14, 82, 18, 33, 41, 64, 57, 66, 95 };

        int[] basicArray = new int[10];
        for (int i = 0; i < basicArray.length; i++) {
            basicArray[i] = (int) (Math.random() * 100);
        }
        System.out.println("Basic array:" + Arrays.toString(basicArray));

        int sum = 0;
        BigDecimal multiplicationResult = new BigDecimal("1");
        for (int i = 0; i < basicArray.length; i++) {
            sum += basicArray[i];
            multiplicationResult = multiplicationResult.multiply(new BigDecimal(basicArray[i]));
        }

        System.out.println("Sum = " + sum);
        System.out.println("Result of multiplication = " + multiplicationResult);
    }
}
