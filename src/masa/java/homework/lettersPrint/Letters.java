package masa.java.homework.lettersPrint;

public class Letters {
    public static int LETTERS_HEIGHT = 7;
    public static int LETTERS_WIDTH = 5;
    public static boolean readyToPrintLetter(char c){
        return (c == 'A') || (c == 'B') || (c == 'C') || (c == 'D') || (c == 'E') || (c == 'F') || (c == 'G');
    }

    public static final char[][] LETTER_A = {
            {' ',' ','A',' ',' '},
            {' ','A',' ','A',' '},
            {'A',' ',' ',' ','A'},
            {'A','A','A','A','A'},
            {'A',' ',' ',' ','A'},
            {'A',' ',' ',' ','A'},
            {'A',' ',' ',' ','A'}
    };

    public static final char[][] LETTER_B = {
            {'B','B','B','B',' '},
            {'B',' ',' ',' ','B'},
            {'B',' ',' ',' ','B'},
            {'B','B','B','B',' '},
            {'B',' ',' ',' ','B'},
            {'B',' ',' ',' ','B'},
            {'B','B','B','B',' '}
    };

    public static final char[][] LETTER_C = {
            {' ','C','C','C',' '},
            {'C',' ',' ',' ','C'},
            {'C',' ',' ',' ',' '},
            {'C',' ',' ',' ',' '},
            {'C',' ',' ',' ',' '},
            {'C',' ',' ',' ','C'},
            {' ','C','C','C',' '}
    };

    public static final char[][] LETTER_D = {
            {'D','D','D','D',' '},
            {'D',' ',' ',' ','D'},
            {'D',' ',' ',' ','D'},
            {'D',' ',' ',' ','D'},
            {'D',' ',' ',' ','D'},
            {'D',' ',' ',' ','D'},
            {'D','D','D','D',' '}
    };

    public static final char[][] LETTER_E = {
            {'E','E','E','E','E'},
            {'E',' ',' ',' ',' '},
            {'E',' ',' ',' ',' '},
            {'E','E','E',' ',' '},
            {'E',' ',' ',' ',' '},
            {'E',' ',' ',' ',' '},
            {'E','E','E','E','E'}
    };

    public static final char[][] LETTER_F = {
            {'F','F','F','F','F'},
            {'F',' ',' ',' ',' '},
            {'F',' ',' ',' ',' '},
            {'F','F','F',' ',' '},
            {'F',' ',' ',' ',' '},
            {'F',' ',' ',' ',' '},
            {'F',' ',' ',' ',' '}
    };

    public static final char[][] LETTER_G = {
            {' ','G','G','G',' '},
            {'G',' ',' ',' ','G'},
            {'G',' ',' ',' ',' '},
            {'G',' ',' ','G','G'},
            {'G',' ',' ',' ','G'},
            {'G',' ',' ',' ','G'},
            {' ','G','G','G',' '}
    };

    public static final char[][] LETTER_H = {
            {' ','G','G','G',' '},
            {'G',' ',' ',' ','G'},
            {'G',' ',' ',' ',' '},
            {'G',' ',' ','G','G'},
            {'G',' ',' ',' ','G'},
            {'G',' ',' ',' ','G'},
            {' ','G','G','G',' '}
    };
}
