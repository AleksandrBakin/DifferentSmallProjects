package masa.java.homework.checkArrayIfSort;

import java.util.Arrays;

/**
 * Напишите программу на Java, чтобы определить, отсортирован ли массив или нет.
 */

public class AppToCheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*10);
        }
        System.out.println("Look at this array: " + Arrays.toString(array));
        boolean isSortedMinToMax = true;
        boolean isSortedMaxToMin = true;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]>array[i+1]) {
                isSortedMinToMax = false;
            }
            if(array[i]<array[i+1]) {
                isSortedMaxToMin = false;
            }
        }
        if ((isSortedMinToMax)||(isSortedMaxToMin)) System.out.println("It is sorted");
        else System.out.println("It is not sorted");
    }
}
