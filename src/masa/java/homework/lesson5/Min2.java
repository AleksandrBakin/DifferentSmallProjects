package masa.java.homework.lesson5;

import java.util.Arrays;
import java.util.Random;

public class Min2 {
    public static void main(String[] args) {
        int n = 10;
        int m = 10;
        int[][] array = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = random.nextInt(500) - 250;
            }
        }
        System.out.println(Arrays.deepToString(array));

        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] < min) { min = array[i][j]; }
            }
        }
        System.out.println(min);
    }
}
