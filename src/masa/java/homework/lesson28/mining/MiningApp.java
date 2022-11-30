package masa.java.homework.lesson28.mining;

public class MiningApp {

    private static int numberOfUnits = 5;
    public static Mine mine;
    public static Castle castle;

    private static StringBuilder[] report = new StringBuilder[numberOfUnits];

    public static void main(String[] args) throws InterruptedException {
        mine = new Mine(500);
        castle = new Castle(0);

        Thread[] workers = new Thread[numberOfUnits];

        for (int i = 0; i < numberOfUnits; i++) { report[i] = new StringBuilder(); }
        for (int i = 0; i < numberOfUnits; i++) { workers[i] = new Worker(i); }
        Thread timer = new MiningTimer();
        for (int i = 0; i < numberOfUnits; i++) { workers[i].join(); }
        timer.interrupt();
        for (int i = 0; i < numberOfUnits; i++) {
            System.out.println(report[i]);
        }
    }

    public static void addToReport (int num, String event) {
        //report[num].append("[").append(event).append("]");
        synchronized (report) {
            for (int i = 0; i < numberOfUnits; i++) {
                if(i == num) {
                    report[i].append("[").append(event).append("]");
                } else {
                    report[i].append("_".repeat(event.length()+2));
                }
            }
        }
    }
}
