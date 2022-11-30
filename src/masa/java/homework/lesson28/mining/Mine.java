package masa.java.homework.lesson28.mining;

public class Mine {
    private int gold;

    public Mine(int gold) {
        this.gold = gold;
    }

    public void mineGold() {
        gold -= 100;
    }

    public int getGold() {
        return gold;
    }

    public boolean isEmpty() {
        return gold == 0;
    }
}
