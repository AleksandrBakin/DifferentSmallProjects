package masa.java.homework.lesson4;

import java.util.Scanner;

public class SimpleNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  Integer.parseInt(sc.nextLine());
        sc.close();
        for (int i = 2; i < n; i++) {
            if(n % 2 == 0) {
                System.out.println("Num " + n + " is not simple");
                return;
            }
        }
        System.out.println("Num " + n + " is simple");
    }
}
