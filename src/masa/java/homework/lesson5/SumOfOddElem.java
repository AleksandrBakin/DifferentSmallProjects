package masa.java.homework.lesson5;

import java.util.Arrays;
import java.util.Random;

public class SumOfOddElem {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(500) - 250;
        }
        System.out.println(Arrays.toString(array));
        int sum = 0;
        for (int i = 1; i < array.length; i+=2) {
            sum += array[i];
        }
        System.out.println(sum);
    }
}
