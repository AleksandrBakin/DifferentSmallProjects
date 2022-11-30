package masa.java.homework.task5;

import java.util.Arrays;

/**
 * Напишите программу, которая находит наибольший и наименьший элементы массива.
 */

public class Solution {
    public static void main(String[] args) {
        int[] basicArray = new int[10];
        for (int i = 0; i < basicArray.length; i++) {
            basicArray[i] = (int) (Math.random() * 100);
        }
        System.out.println("Basic array:" + Arrays.toString(basicArray));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < basicArray.length; i++) {
            if (basicArray[i] > max)
                max = basicArray[i];
            if (basicArray[i] < min)
                min = basicArray[i];
        }
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

}
