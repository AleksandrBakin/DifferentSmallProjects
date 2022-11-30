package masa.java.homework.lesson28.mining;

public class Castle {
    private int gold;

    Castle(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void addGold() {
        gold += 100;
    }
}
