package com.company;

public class Item {
    private String name;
    private int weight;

    public Item (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight () {
        return this.weight;
    }
}
