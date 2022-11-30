package masa.java.homework.lesson24.plague;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlagueApp {

    static int numberIfDays = 5;

    public static void main(String[] args) {
        List<Citizen> city = new ArrayList<>(136);
        city.add(new King());
        for (int i = 0; i < 10; i++) {
            city.add(new Noble());
        }
        for (int i = 0; i < 25; i++) {
            city.add(new Knight());
        }
        for (int i = 0; i < 100; i++) {
            city.add( new Peasant());
        }

        for (int i = 0; i < numberIfDays; i++) {
            Iterator<Citizen> iterator = city.iterator();
            while (iterator.hasNext()) {
                Citizen nextCitizen = iterator.next();
                nextCitizen.damage();
                if(nextCitizen.health == 0) {
                    iterator.remove();
                }
            }
        }

        int kingCounter = 0;
        int nobleCounter = 0;
        int knightCounter = 0;
        int peasantCounter = 0;

        for (Citizen citizen: city) {
            if (citizen instanceof Peasant) { peasantCounter++; }
            else if (citizen instanceof Knight) { knightCounter++; }
            else if (citizen instanceof Noble) { nobleCounter++; }
            else if (citizen instanceof King) {
                kingCounter++;
                System.out.println("King hp = " + citizen.health); }
        }

        System.out.println("Number of Kings alive: " + kingCounter);
        System.out.println("Number of Nobles alive: " + nobleCounter);
        System.out.println("Number of Knights alive: " + knightCounter);
        System.out.println("Number of Peasant alive: " + peasantCounter);
        System.out.println("Total population: " + (kingCounter+knightCounter+nobleCounter+peasantCounter));
    }
}
