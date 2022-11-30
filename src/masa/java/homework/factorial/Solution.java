package masa.java.homework.factorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int inputNumber = 0;
        Scanner sc;
        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter your number from 0 to 6800");
                String input = sc.nextLine();
                inputNumber = Integer.parseInt(input);
                if( inputNumber >= 0 && inputNumber <= 6800 ) {
                    break;
                } else {
                    System.out.println("Wrong input, try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, try again");
            }
        }
        sc.close();
        System.out.println("Factorial of " + inputNumber + " :");
        //System.out.println(fact(new BigInteger(String.valueOf(inputNumber))));
        System.out.println(String.valueOf(fact(new BigInteger(String.valueOf(inputNumber)))).length());
    }

    static BigInteger fact(BigInteger integer) {
        if(integer.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        }else {
            return integer.multiply(fact(integer.subtract(new BigInteger("1"))));
        }
    }
}
