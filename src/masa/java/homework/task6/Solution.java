package masa.java.homework.task1;

import java.util.Arrays;

/**
 * Создайте переменную массива с 10 целочисленными данным.
 * Создайте случайную переменную.
 * Теперь сообщите пользователю, присутствует ли это число в массиве или нет.
 */

public class Solution {
    public static void main(String[] args) {
        int arraySize = (int) (Math.random() * 20);
        int[] numbers = new int[arraySize];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }
        System.out.println("My array: " + Arrays.toString(numbers));
        int numberToFind = (int) (Math.random() * 10);
        System.out.println("My number to find: " + numberToFind);
        for (int i = 0; i < numbers.length; i++) {
            if (numberToFind == numbers[i]) {
                System.out.println("My array conteins this number! Index = " + i);
                break;
            } else if (i == numbers.length - 1) {
                System.out.println("My array doesn't conteins this number");
            }
        }
    }
}