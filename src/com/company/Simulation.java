package com.company;

import java.util.List;
import java.util.*;
import java.io.File;


public class Simulation {

    public Simulation () {
        List <Item> phase1List = this.loadItems("phase-1.txt");
        List <Item> phase2List = this.loadItems("phase-2.txt");

        List <Rocket> u1Phase1 = this.loadU1(phase1List);
        List <Rocket> u1Phase2 = this.loadU1(phase2List);

        long u1Phase1Cost = this.runSimulation(u1Phase1, U1.cost);
        long u1Phase2Cost = this.runSimulation(u1Phase2, U1.cost);

        System.out.println("The cost for sending U1 rockets is " + (u1Phase1Cost + u1Phase2Cost) + "$");


        List <Rocket> u2Phase1 = this.loadU2(phase1List);
        List <Rocket> u2Phase2 = this.loadU2(phase2List);

        long u2Phase1Cost = this.runSimulation(u2Phase1, U2.cost);
        long u2Phase2Cost = this.runSimulation(u2Phase2, U2.cost);

        System.out.println("The cost for sending U2 rockets is " + (u2Phase1Cost + u2Phase2Cost) + "$");

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

    private List<Rocket> loadU1 (List<Item> itemList) {
        List<Rocket> u1Rockets = new ArrayList<Rocket>();
        U1 rocket = new U1();

        for (Item item: itemList) {
            if (!rocket.canCarry(item)) {
                u1Rockets.add(rocket);
                rocket = new U1();
            }
            rocket.carry(item);
        }
        return u1Rockets;
    }

    private List<Rocket> loadU2 (List<Item> itemList) {
        List<Rocket> u2Rockets = new ArrayList<Rocket>();
        U2 rocket = new U2();

        for (Item item: itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                u2Rockets.add(rocket);
                rocket = new U2();
            }
        }
        return u2Rockets;
    }

    private long runSimulation (List<Rocket> rocketList, int cost) {
        int rocketCount = 0;
        int rocketCost;

        for (Rocket rocket : rocketList) {
            while (!rocket.launch() || !rocket.land()) {
                rocketCount++;
            }
            rocketCount++;
        }
        return ((long)rocketCount * (long)cost);
    }
}
