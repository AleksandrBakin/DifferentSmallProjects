package masa.java.homework.lesson5;

import java.util.Arrays;
import java.util.Random;

public class Average {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(500) - 250;
        }
        System.out.println(Arrays.toString(array));

        double average = array[0];
        for (int i = 1; i < array.length; i++) {
            average += array[i];
        }
        average /= array.length;
        System.out.println(average);
    }
}
