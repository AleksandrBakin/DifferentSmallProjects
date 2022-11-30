package masa.java.homework.lesson5;

import java.util.Arrays;
import java.util.Random;

public class NumOfOddElem {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10) - 5;
        }
        System.out.println(Arrays.toString(array));

        int oddCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) { oddCounter++; }
        }
        System.out.println(oddCounter);
    }
}
