package masa.java.homework.lesson24.plague;

import java.util.Random;

public abstract class Citizen {
    int health;

    int maxHealth;

    Citizen(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void damage() {
        if(health > 0) { health = health - (new Random().nextInt(1,5) * 10); }
        if(health < 0) health = 0;
    }
}
