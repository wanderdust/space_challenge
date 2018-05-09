package com.company;

public class Rocket implements SpaceShip {
    protected int weight;
    protected int maxWeight;

    public Rocket(int weight, int maxWeight) {
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    // We check chances of explosion out of a 1.000.000
    public boolean launch() {
        return true;
    }

    // We check chances of explosion out of a 1.000.000
    public boolean land () {
        return true;
    }

    public final boolean canCarry (Item item) {
        int updatedWeight = this.weight + item.getWeight();

        return updatedWeight <= this.maxWeight;
    }

    public final void carry (Item item) {

        this.weight += item.getWeight();
    }

    public int getWeight () {
        return this.weight;
    }
}
