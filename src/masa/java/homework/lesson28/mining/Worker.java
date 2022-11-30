package masa.java.homework.lesson28.mining;

import java.util.Random;

import static masa.java.homework.lesson28.mining.MiningApp.castle;
import static masa.java.homework.lesson28.mining.MiningApp.mine;

public class Worker extends Thread {

    int speed = new Random().nextInt(1, 5);
    int goldCarried = 0;

    int number;

    public Worker(int number) {
        super("Worker " + (number + 1));
        this.number = number;
//        System.out.println(getName() + " started mining");
        MiningApp.addToReport( number,getName() + " started mining");
        start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mine) {
                if(mine.isEmpty()) { break; }
//                System.out.println(getName() + " is in Mine");
                MiningApp.addToReport( number,getName() + " is in Mine");
                try {
                    Thread.sleep(5_000/speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                mine.mineGold();
//                System.out.print(getName() + " finished in Mine. ");
//                System.out.println(mine.getGold() + " gold left.");
                MiningApp.addToReport( number,getName() + " finished in Mine. " + mine.getGold() + " gold left.");
            }

            {
//                System.out.println(getName() + " is going to Castle");
                MiningApp.addToReport( number,getName() + " is going to Castle");
                try {
                    Thread.sleep(10_000/speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
//                System.out.println(getName() + " finished his way to Castle.");
                MiningApp.addToReport( number,getName() + " finished his way to Castle.");
            }

            synchronized (castle) {
//                System.out.println(getName() + " is in Castle");
                MiningApp.addToReport( number,getName() + " is in Castle");
                try {
                    Thread.sleep(3_000/speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                castle.addGold();
                goldCarried += 100;
//                System.out.print(getName() + " finished in Castle. ");
//                System.out.println(castle.getGold() + " gold now in Castle.");
                MiningApp.addToReport( number,getName() + " finished in Castle. " + castle.getGold() + " gold now in Castle.");
            }

            {
//                System.out.println(getName() + " is going back to Mine");
                MiningApp.addToReport( number,getName() + " is going back to Mine");
                try {
                    Thread.sleep(8_000/speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
//                System.out.println(getName() + " finished his way to Mine.");
                MiningApp.addToReport( number,getName() + " finished his way to Mine.");
            }
        }
//        System.out.print(getName() + " finished Mining. He totally carried " + goldCarried + " gold.");
//        System.out.println("his sped was " + speed);
        MiningApp.addToReport( number,getName() + " finished Mining. He totally carried " + goldCarried + " gold." + "his speed was " + speed);
    }

    public int getSpeed() {
        return speed;
    }
}
