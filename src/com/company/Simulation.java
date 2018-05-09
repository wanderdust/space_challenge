package com.company;

import java.util.List;
import java.util.*;
import java.util.Arrays;
import java.io.File;


public class Simulation {

    public Simulation () {
        List <Item> itemList = this.loadItems("phase-2.txt");
        List <U1> u1Rockets = this.loadU1(itemList);

        for (U1 u1 : u1Rockets) {
            System.out.println(u1.getWeight());
        }
    }

    private List<Item> loadItems (String phase) {
        List<Item> itemList = new ArrayList<Item>();

        try {
            File file = new File(phase);
            Scanner scanner;

            scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String [] line = scanner.nextLine().split("=");
                String itemName = line[0];
                int itemWeight = Integer.parseInt(line[1]);

                Item item = new Item(itemName, itemWeight);
                itemList.add(item);
            }
            return itemList;

        } catch ( Exception exception ) {
            return null;
        }
    }

    private List<U1> loadU1 (List<Item> itemList) {
        List<U1> u1Rockets = new ArrayList<U1>();
        U1 rocket = new U1();

        for (Item item: itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                u1Rockets.add(rocket);
                rocket = new U1();
            }
        }
        return u1Rockets;
    }
}
