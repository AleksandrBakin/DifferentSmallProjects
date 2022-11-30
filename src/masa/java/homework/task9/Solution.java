package masa.java.homework.task3;

import java.util.Arrays;

/**
 * Создайте массив Теперь скопируйте все элементы в другой массив,
 * но в обратном порядке.
 */

public class Solution {
    public static void main(String[] args) {
        int[] basicArray = new int[10];
        for (int i = 0; i < basicArray.length; i++) {
            basicArray[i] = i;
        }
        System.out.println("Basic array:" + Arrays.toString(basicArray));
        int[] reversedArray = new int[basicArray.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = basicArray[basicArray.length - 1 - i];
        }
        System.out.println("Reversed array:" + Arrays.toString(reversedArray));
    }
}
