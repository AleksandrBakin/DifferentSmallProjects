package masa.java.homework.lettersPrint;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = new String[3];
        System.out.println("Type name:");
        name[0] = reader.readLine();
        if ((name[0] == null)||("".equals(name[0]))) throw new IllegalArgumentException("String is empty");
        System.out.println("Type father's name:");
        name[1] = reader.readLine();
        if ((name[1] == null)||("".equals(name[1]))) throw new IllegalArgumentException("String is empty");
        System.out.println("Type family name:");
        name[2] = reader.readLine();
        if ((name[2] == null)||("".equals(name[2]))) throw new IllegalArgumentException("String is empty");
        System.out.printf("For the name %s %s %s...%n",name[0],name[1],name[2]);
        print3Letters(getFirstLetter(name[0]),getFirstLetter(name[1]),getFirstLetter(name[2]));
    }


    public static void print3Letters(char c1, char c2, char c3) {
        if (!Letters.readyToPrintLetter(c1)) throw new IllegalArgumentException("No such letter :(");
        if (!Letters.readyToPrintLetter(c2)) throw new IllegalArgumentException("No such letter :(");
        if (!Letters.readyToPrintLetter(c3)) throw new IllegalArgumentException("No such letter :(");
        for (int i = 0; i < Letters.LETTERS_HEIGHT; i++) {
            switch (c1) {
                case 'A':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_A[i][j]+" ");
                    }
                    break;
                case 'B':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_B[i][j]+" ");
                    }
                    break;
                case 'C':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_C[i][j]+" ");
                    }
                    break;
                case 'D':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_D[i][j]+" ");
                    }
                    break;
                case 'E':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_E[i][j]+" ");
                    }
                    break;
                case 'F':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_F[i][j]+" ");
                    }
                    break;
                case 'G':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_G[i][j]+" ");
                    }
                    break;
            }
            System.out.print("  ");
            switch (c2) {
                case 'A':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_A[i][j]+" ");
                    }
                    break;
                case 'B':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_B[i][j]+" ");
                    }
                    break;
                case 'C':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_C[i][j]+" ");
                    }
                    break;
                case 'D':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_D[i][j]+" ");
                    }
                    break;
                case 'E':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_E[i][j]+" ");
                    }
                    break;
                case 'F':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_F[i][j]+" ");
                    }
                    break;
                case 'G':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_G[i][j]+" ");
                    }
                    break;
            }
            System.out.print("  ");
            switch (c3) {
                case 'A':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_A[i][j]+" ");
                    }
                    break;
                case 'B':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_B[i][j]+" ");
                    }
                    break;
                case 'C':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_C[i][j]+" ");
                    }
                    break;
                case 'D':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_D[i][j]+" ");
                    }
                    break;
                case 'E':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_E[i][j]+" ");
                    }
                    break;
                case 'F':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_F[i][j]+" ");
                    }
                    break;
                case 'G':
                    for (int j = 0; j < Letters.LETTERS_WIDTH; j++) {
                        System.out.print(Letters.LETTER_G[i][j]+" ");
                    }
                    break;
            }
            System.out.print("\n");
        }
    }

    public static char getFirstLetter(String str) {
        if ((str == null)||(str.length()<1)) throw new IllegalArgumentException("String is empty");
        return Character.toUpperCase(str.charAt(0));
    }
}
