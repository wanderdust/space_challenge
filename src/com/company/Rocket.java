package com.company;

import java.util.Random;

public class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected int maxWeight;

    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    // We check chances of explosion out of a 1.000.000
    public final boolean launch(int weight, int maxWeight, double chances) {
        double chanceOfExplosion = chances * ((double)weight / (double)maxWeight) * 1000000;
        Random random = new Random();
        double randomNumber = random.nextInt(1000000 + 1);

        return chanceOfExplosion <= randomNumber;
    }

    // We check chances of explosion out of a 1.000.000
    public final boolean land (int weight, int maxWeight, double chances) {
        double chanceOfExplosion = chances * ((double)weight / (double)maxWeight) * 1000000;
        Random random = new Random();
        double randomNumber = random.nextInt(1000000 + 1);

        return chanceOfExplosion <= randomNumber;
    }

    public final boolean canCarry (Item item) {
        int updatedWeight = this.weight + item.getWeight();

        return updatedWeight <= this.maxWeight;
    }

    public final void carry (Item item) {
        this.weight += item.getWeight();
    }
}
