package masa.java.homework.lesson5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Mult {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(500) - 250;
        }
        System.out.println(Arrays.toString(array));

        BigInteger mult = new BigInteger(String.valueOf(array[0]));
        for (int i = 1; i < array.length; i++) {
            mult = mult.multiply(new BigInteger(String.valueOf(array[i])));
        }
        System.out.println(mult);
    }
}
