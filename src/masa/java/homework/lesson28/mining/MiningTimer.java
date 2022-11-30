package masa.java.homework.lesson28.mining;

public class MiningTimer extends Thread{

    public MiningTimer() {
        start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                i++;
                System.out.println("Mining for "  + ( i>99 ? i : ( i > 9 ? " "+i : "  "+i )) + " sec, please wait...");
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
