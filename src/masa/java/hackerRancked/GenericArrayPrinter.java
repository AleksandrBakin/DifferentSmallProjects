package masa.java.hackerRancked;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericArrayPrinter {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("/Users/aleksandrbakin/Java/JavaProjects/DifferentProjects/src/masa/java/hackerRancked/TestFile"));
        List<String> list = new ArrayList<>();
        while(sc.hasNext()) {
            list.add(sc.nextLine());
        }
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (String string : list) {
            try{
                int n = Integer.parseInt(string);
                intList.add(n);
            } catch (NumberFormatException e) {
                strList.add(string);
            }
        }
        printArray(intList.toArray(new Integer[0]));
        printArray(strList.toArray(new String[0]));
    }

    static <E> void printArray(E[] array ) {
        for (E element : array) {
            System.out.println(element);
        }
    }
}