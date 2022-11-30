package masa.java.homework.advancedArray;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AdvancedArray list = new AdvancedArray();
        System.out.println("I want to create advanced array size of 3 and fill it with zeroes");
        list.createArray(3);
        list.printArray();
        System.out.println("\nI want to add 5 numbers from 1 to 5 in the end of advanced array");
        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        list.printArray();
        System.out.println("\nI want to turn my advanced array to 5,5,5,5,5,10,10,10,10,10");
        int[] testArray = {5,5,5,5,5,10,10,10,10,10};
        list.setArray(testArray);
        list.printArray();
        System.out.println("\nI want to add 5 numbers -1 in the end of advanced array");
        for (int i = 0; i < 5; i++) {
            list.printArray();
            list.add(-1);
        }
        list.printArray();
        System.out.println("\nI want to remove elements number 4,8 and 12 from advanced array");
        list.remove(4);
        list.remove(8);
        list.remove(12);
        list.printArray();
        System.out.println("\nI want to get element number 3,7 and 11 from advanced array");
        System.out.println(list.get(3) + " " + list.get(7) + " " + list.get(11));
    }
}
