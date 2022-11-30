package masa.java.homework.advanced.mySeaBattle;

public class SBPoint {
    int i;
    int j;

    public SBPoint() {
        this.i = (int) (Math.random() * (SeaBattle.getBattleFieldWidth() - 1));
        this.j = (int) (Math.random() * (SeaBattle.getBattleFieldWidth() - 1));
    }

    public SBPoint(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Проверяет, находится ли точка в пределах поля
    // Потом проверяет, что точка не занята, а потому проверяет точки вокруг
    public boolean checkSBPoint(int[][] battleField) {
        if ((this.i >= 0) && (this.i < SeaBattle.getBattleFieldWidth()) && (this.j >= 0)
                && (this.j < SeaBattle.getBattleFieldWidth())) {
            // point exists
            if (battleField[this.i][this.j] == 0) {
                // point if empty
                return checkSBPointAroundArea(battleField);
            }
            return false;
        }
        return false;
    }

    // Проверяет, чтобы все точки вокруг были путыми или лежали за пределами поля
    public boolean checkSBPointAroundArea(int[][] battleField) {
        for (int iTmp = this.i - 1; iTmp <= this.i + 1; iTmp++) {
            for (int jTmp = this.j - 1; jTmp <= this.j + 1; jTmp++) {
                if ((iTmp >= 0) && (iTmp < SeaBattle.getBattleFieldWidth()) && (jTmp >= 0)
                        && (jTmp < SeaBattle.getBattleFieldWidth())) {
                    // inside the field
                    if (battleField[iTmp][jTmp] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public SBPoint getSBPoint1PosUp() { // - 0
        return new SBPoint(this.i - 1, this.j);
    }

    public SBPoint getSBPoint1PosUpAndRight() { // - +
        return new SBPoint(this.i - 1, this.j + 1);
    }

    public SBPoint getSBPoint1PosRight() { // // 0 +
        return new SBPoint(this.i, this.j + 1);
    }

    public SBPoint getSBPoint1PosRightAndDown() { // + +
        return new SBPoint(this.i + 1, this.j + 1);
    }

    public SBPoint getSBPoint1PosDown() { // + 0
        return new SBPoint(this.i + 1, this.j);
    }

    public SBPoint getSBPoint1PosDownAndLeft() { // + -
        return new SBPoint(this.i + 1, this.j - 1);
    }

    public SBPoint getSBPoint1PosLeft() { // 0 -
        return new SBPoint(this.i, this.j - 1);
    }

    public SBPoint getSBPoint1PosLeftAndUp() { // - -
        return new SBPoint(this.i - 1, this.j - 1);
    }
}