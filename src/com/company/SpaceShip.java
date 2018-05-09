package com.company;

public interface SpaceShip {
    boolean launch(int weight, int maxWeight, double chances);
    boolean land(int weight, int maxWeight, double chances);
    boolean canCarry(Item item);
    void carry(Item item);
}
