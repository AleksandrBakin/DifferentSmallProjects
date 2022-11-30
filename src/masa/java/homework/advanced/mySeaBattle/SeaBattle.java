package masa.java.homework.advanced.mySeaBattle;


/**
 * Написать функции, каждая из которых по правилам игры морской бой расставляет
 * случайным образом:
 * 10 однопалубных кораблей; - есть
 * 10 двухпалубных кораблей; - есть улучшить
 * 5 трехпалубных кораблей; - есть улучшить
 * Расставляет все корабли для игры в морской бой
 * (4 однопалубных, 3 двухпалубных, 2 трехпалубных, 1 четырехпалубный).
 * 
 */

public class SeaBattle {
    private static final int[][] EXAMPLE_BATTLE_FIELD = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 0
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 1
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 2
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 3
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 4
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 5
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 6
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 7
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // i = 8
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } // i = 9

            // j= 0 1 2 3 4 5 6 7 8 9
    };
    private static final int BATTLE_FIELD_WIDTH = 10;
    private static final int NUMBER_OF_SHIPS_TO_PLACE = 10;

    public static void main(String[] args) throws InterruptedException {
        int[][] result1 = placeSingleShips(getNewEmptyBattleField(), NUMBER_OF_SHIPS_TO_PLACE);
        printBattleField(result1);
        int[][] result2 = placeDoubleShips(getNewEmptyBattleField(), NUMBER_OF_SHIPS_TO_PLACE);
        printBattleField(result2);
        int[][] result3 = placeTripleShips(getNewEmptyBattleField(), NUMBER_OF_SHIPS_TO_PLACE / 2);
        printBattleField(result3);
        int[][] result4 = placeQuartoShips(getNewEmptyBattleField(), 3);
        printBattleField(result4);
        int[][] result5 = fillBattleFieldForGame(getNewEmptyBattleField());
        printBattleField(result5);
    }

    public static int[][] getNewEmptyBattleField() {
        int[][] emptyBattleField = new int[BATTLE_FIELD_WIDTH][BATTLE_FIELD_WIDTH];
        for (int i = 0; i < emptyBattleField.length; i++) {
            for (int j = 0; j < emptyBattleField.length; j++) {
                emptyBattleField[i][j] = 0;
            }
        }
        return emptyBattleField;
    }

    public static int[][] placeSingleShips(int[][] battleFild, int numberOfShipsToPlace) {
        SBPoint point = new SBPoint();
        if (point.checkSBPoint(battleFild)) {
            battleFild[point.i][point.j] = 1;
            if (numberOfShipsToPlace != 1)
                return placeSingleShips(battleFild, numberOfShipsToPlace - 1);
            else
                return battleFild;
        }
        return placeSingleShips(battleFild, numberOfShipsToPlace);
    }

    public static int[][] placeDoubleShips(int[][] battleFild, int numberOfShipsToPlace) {
        SBPoint point = new SBPoint();
        int typeOfShip = (int) Math.round(Math.random());
        if (typeOfShip == 0) {
            if (point.checkSBPoint(battleFild) && point.getSBPoint1PosUp().checkSBPoint(battleFild)) {
                battleFild[point.i][point.j] = 1;
                battleFild[point.getSBPoint1PosUp().i][point.getSBPoint1PosUp().j] = 1;
                if (numberOfShipsToPlace != 1) {
                    return placeDoubleShips(battleFild, numberOfShipsToPlace - 1);
                } else {
                    return battleFild;
                }
            }
        } else {
            if (point.checkSBPoint(battleFild) && point.getSBPoint1PosRight().checkSBPoint(battleFild)) {
                battleFild[point.i][point.j] = 1;
                battleFild[point.getSBPoint1PosRight().i][point.getSBPoint1PosRight().j] = 1;
                if (numberOfShipsToPlace != 1) {
                    return placeDoubleShips(battleFild, numberOfShipsToPlace - 1);
                } else {
                    return battleFild;
                }
            }
        }
        return placeDoubleShips(battleFild, numberOfShipsToPlace);
    }

    public static int[][] placeTripleShips(int[][] battleFild, int numberOfShipsToPlace) {
        SBPoint point = new SBPoint();
        int typeOfShip = (int) Math.round(Math.random());
        if (typeOfShip == 0) {
            if (point.checkSBPoint(battleFild) && point.getSBPoint1PosUp().checkSBPoint(battleFild) &&
                    point.getSBPoint1PosUp().getSBPoint1PosUp().checkSBPoint(battleFild)) { // Two times up
                // Vertical
                battleFild[point.i][point.j] = 1;
                battleFild[point.getSBPoint1PosUp().i][point.getSBPoint1PosUp().j] = 1;
                battleFild[point.getSBPoint1PosUp().getSBPoint1PosUp().i][point.getSBPoint1PosUp()
                        .getSBPoint1PosUp().j] = 1;
                if (numberOfShipsToPlace != 1) {
                    return placeTripleShips(battleFild, numberOfShipsToPlace - 1);
                } else {
                    return battleFild;
                }
            }
        } else {
            if (point.checkSBPoint(battleFild) && point.getSBPoint1PosRight().checkSBPoint(battleFild) &&
                    point.getSBPoint1PosRight().getSBPoint1PosRight().checkSBPoint(battleFild)) { // Two times right
                // Horizontal
                battleFild[point.i][point.j] = 1;
                battleFild[point.getSBPoint1PosRight().i][point.getSBPoint1PosRight().j] = 1;
                battleFild[point.getSBPoint1PosRight().getSBPoint1PosRight().i][point.getSBPoint1PosRight()
                        .getSBPoint1PosRight().j] = 1;
                if (numberOfShipsToPlace != 1) {
                    return placeTripleShips(battleFild, numberOfShipsToPlace - 1);
                } else {
                    return battleFild;
                }
            }
        }
        return placeTripleShips(battleFild, numberOfShipsToPlace);
    }

    public static int[][] placeQuartoShips(int[][] battleFild, int numberOfShipsToPlace) {
        SBPoint point = new SBPoint();
        int typeOfShip = (int) Math.round(Math.random());
        if (typeOfShip == 0) {
            if (point.checkSBPoint(battleFild) && point.getSBPoint1PosUp().checkSBPoint(battleFild) &&
                    point.getSBPoint1PosUp().getSBPoint1PosUp().checkSBPoint(battleFild) &&
                    point.getSBPoint1PosUp().getSBPoint1PosUp().getSBPoint1PosUp().checkSBPoint(battleFild)) {
                // Vertical
                battleFild[point.i][point.j] = 1;
                battleFild[point.getSBPoint1PosUp().i][point.getSBPoint1PosUp().j] = 1;
                battleFild[point.getSBPoint1PosUp().getSBPoint1PosUp().i][point.getSBPoint1PosUp()
                        .getSBPoint1PosUp().j] = 1;
                battleFild[point.getSBPoint1PosUp().getSBPoint1PosUp().getSBPoint1PosUp().i][point.getSBPoint1PosUp()
                        .getSBPoint1PosUp().getSBPoint1PosUp().j] = 1;
                if (numberOfShipsToPlace != 1) {
                    return placeQuartoShips(battleFild, numberOfShipsToPlace - 1);
                } else {
                    return battleFild;
                }
            }
        } else {
            if (point.checkSBPoint(battleFild) && point.getSBPoint1PosRight().checkSBPoint(battleFild) &&
                    point.getSBPoint1PosRight().getSBPoint1PosRight().checkSBPoint(battleFild) &&
                    point.getSBPoint1PosRight().getSBPoint1PosRight().getSBPoint1PosRight()
                            .checkSBPoint(battleFild)) {
                // Horizontal
                battleFild[point.i][point.j] = 1;
                battleFild[point.getSBPoint1PosRight().i][point.getSBPoint1PosRight().j] = 1;
                battleFild[point.getSBPoint1PosRight().getSBPoint1PosRight().i][point.getSBPoint1PosRight()
                        .getSBPoint1PosRight().j] = 1;
                battleFild[point.getSBPoint1PosRight().getSBPoint1PosRight().getSBPoint1PosRight().i][point
                        .getSBPoint1PosRight().getSBPoint1PosRight().getSBPoint1PosRight().j] = 1;
                if (numberOfShipsToPlace != 1) {
                    return placeQuartoShips(battleFild, numberOfShipsToPlace - 1);
                } else {
                    return battleFild;
                }
            }
        }
        return placeQuartoShips(battleFild, numberOfShipsToPlace);
    }

    public static int[][] fillBattleFieldForGame(int[][] battleFild) {
        int[][] battleFieldForTheRealGame = placeQuartoShips(battleFild, 1);
        battleFieldForTheRealGame = placeTripleShips(battleFieldForTheRealGame, 2);
        battleFieldForTheRealGame = placeDoubleShips(battleFieldForTheRealGame, 3);
        battleFieldForTheRealGame = placeSingleShips(battleFieldForTheRealGame, 4);
        return battleFieldForTheRealGame;
    }

    public static int getBattleFieldWidth() {
        return SeaBattle.BATTLE_FIELD_WIDTH;
    }

    public static void printBattleField(int[][] battleFild) {
        for (int i = 0; i < BATTLE_FIELD_WIDTH; i++) {
            for (int j = 0; j < BATTLE_FIELD_WIDTH; j++) {
                if (battleFild[i][j] == 1) {
                    System.out.print(battleFild[i][j] + " ");
                } else {
                    System.out.print(battleFild[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
