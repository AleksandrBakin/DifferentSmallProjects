package masa.java.homework.vowels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Напишите метод Java для подсчета всех гласных в строке.
 */

public class Vowels {
    public static final String ALL_VOWELS = "AaEeIiOoUuYy";
    public static int countVowels (String inputString) {
        int vowelsNumber = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if(ALL_VOWELS.contains(String.valueOf(inputString.charAt(i)))) vowelsNumber++;
        }
        return vowelsNumber;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter your string:");
            String inputString = reader.readLine();
            System.out.println("Number of vowels in this String " + countVowels(inputString));
            System.out.println("Do you want to count vowels in one more string? Y/N");
            if(!reader.readLine().equalsIgnoreCase("y")) break;
        }
        System.out.println("Bye!");
    }

}
