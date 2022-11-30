package masa.java.homework.cesarCipher;

import java.util.Arrays;

/**
 * Создайте массив с 10 целочисленными данными от пользователя и напишите
 * программу,которая сдвигает каждый элемент массива вправо по кругу:
 * Пример:
 * Input array:
 * 1, 4, 5, 6, 8, 9, 78, 9, 45, 10
 * Result:
 * 10, 1, 4, 5, 6, 8, 9, 78, 9, 45
 */

public class CesarCipher {
    public static void main(String[] args) {
        // int[] basicArray = { 1, 4, 5, 6, 8, 9, 78, 9, 45, 10 };
        int[] basicArray = new int[10];
        for (int i = 0; i < basicArray.length; i++) {
            basicArray[i] = (int) (Math.random() * 100);
        }
        System.out.println("Basic array:" + Arrays.toString(basicArray));

        int[] newArray = new int[basicArray.length];
        int n = 2;
        for (int i = 0; i < basicArray.length; i++) {
            newArray[(i + n) % basicArray.length] = basicArray[i];
        }
        System.out.println("New array:" + Arrays.toString(newArray));
    }
}
