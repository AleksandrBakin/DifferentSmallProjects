package masa.java.homework.lesson5;

import java.util.Arrays;
import java.util.Random;

public class NumOfEvenElem {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10) - 5;
        }
        System.out.println(Arrays.toString(array));

        int evenCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) { evenCounter++; }
        }
        System.out.println(evenCounter);
    }

}
