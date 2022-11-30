package masa.java.homework.lesson4;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  Integer.parseInt(sc.nextLine());
        sc.close();
        for (int i = 0; i < n; i++) {
            String s = "*".repeat(n-i);
            System.out.println(s);
        }
    }
}
