package masa.java.homework.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Calculator which can do '+' '-' '*' '/' '^'
 * with different doubles and does this until
 * user decide to exit
 */

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String doYouWandToQuit = "";
            while (!doYouWandToQuit.equalsIgnoreCase("q")) {
                String aString, bString;
                double a, b, c;
                char operation;
                System.out.println("Enter first number");
                try {
                    aString = reader.readLine();
                    a = Double.parseDouble(aString);
                } catch (NumberFormatException e) {
                    System.out.println("Your first number is incorrect");
                    continue;
                }
                System.out.println("Enter operation number");
                operation = reader.readLine().charAt(0);
                if ((operation != '+') && (operation != '-') && (operation != '*')
                        && (operation != '/') && (operation != '^')) {
                    System.out.println("Your operation is incorrect");
                    continue;
                }
                System.out.println("Enter second number");
                try {
                    bString = reader.readLine();
                    b = Double.parseDouble(bString);
                } catch (NumberFormatException e) {
                    System.out.println("Your second number is incorrect");
                    continue;
                }
                if ((operation == '/') && (b == 0.0)) {
                    System.out.println("You can't divide by zero");
                    continue;
                }
                c = calculate(a,operation,b);
                if(c==(int)c) {
                    int cInt = (int) c;
                    System.out.println(aString + " " + operation + " " + bString + " = " + cInt );
                } else {
                    System.out.println(aString + " " + operation + " " + bString + " = " + c);
                }
                System.out.println("If you want to quit, enter \"q\" or \"Q\"!");
                doYouWandToQuit = reader.readLine();
            }
            System.out.println("Good bye!");
        }
    }

    public static double calculate (double a, char operation, double b ){
        double c = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '^' -> Math.pow(a, b);
            default -> 0;
        };
        return c;
    }
}