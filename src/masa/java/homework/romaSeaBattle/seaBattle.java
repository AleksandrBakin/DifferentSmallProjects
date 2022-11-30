package masa.java.homework.romaSeaBattle;

import java.util.Random;

public class seaBattle {
    public static int setShip(int field[][], int lenghtShips) {
        Random rand = new Random(); // instance of random class
        int sizeField = field.length;
        int x0 = rand.nextInt(sizeField);
        int y0 = rand.nextInt(sizeField);
        int vect = rand.nextInt(2);
        int x1 = x0;
        int y1 = y0;

        if (vect == 0) {
            x1 += lenghtShips - 1;
        } else {
            y1 += lenghtShips - 1;
        }

        if (x1 >= sizeField || y1 >= sizeField) {
            return 0;
        }

        boolean isEmpty = true;

        for (int x = x0 - 1; x <= x1 + 1; x++) {
            for (int y = y0 - 1; y <= y1 + 1; y++) {
                if (x >= 0 && x < sizeField && y >= 0 && y < sizeField) {
                    if (field[x][y] == 1) {
                        isEmpty = false;
                    }
                }
            }
        }

        if (isEmpty) {
            for (int i = x0; i <= x1; i++) {
                for (int j = y0; j <= y1; j++) {
                    field[i][j] = 1;
                }
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] argv) {
        int sizeField = 10;
        int[][] field = new int[sizeField][sizeField];

        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < sizeField; i++) {
                for (int j = 0; j < sizeField; j++) {
                    field[i][j] = 0;
                }
            }

            int cnt = 0;
            int cntOneDeck = 4;
            int cntTwoDeck = 3;
            int cntThreeDeck = 2;
            int cntFourDeck = 1;

            while (cntOneDeck > 0 && cnt < 100000) {
                cntOneDeck -= setShip(field, 1);
            }
            while (cntTwoDeck > 0 && cnt < 100000) {
                cntTwoDeck -= setShip(field, 2);
            }
            while (cntThreeDeck > 0 && cnt < 100000) {
                cntThreeDeck -= setShip(field, 3);
            }
            while (cntFourDeck > 0 && cnt < 100000) {
                cntFourDeck -= setShip(field, 4);
            }
            flag = cntFourDeck == 0 && cntThreeDeck == 0 && cntTwoDeck == 0 && cntOneDeck == 0;
        }

        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                System.out.print(field[i][j]);
            }
            System.out.print("\n");
        }
    }

}