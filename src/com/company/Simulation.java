package com.company;

import java.util.List;
import java.util.*;
import java.util.Arrays;
import java.io.File;


public class Simulation {

    public Simulation () {
        this.loadItems();
    }

    private List<Item> loadItems () {
        List<File> files = new ArrayList<File>();
        List<Item> itemList = new ArrayList<Item>();

        try {
            File phase1 = new File("phase-1.txt");
            File phase2 = new File("phase-2.txt");
            Scanner scanner;

            files.add(phase1);
            files.add(phase2);

            for (File file : files) {
                scanner = new Scanner(file);

                while(scanner.hasNextLine()) {
                    String [] line = scanner.nextLine().split("=");
                    String itemName = line[0];
                    int itemWeight = Integer.parseInt(line[1]);

                    Item item = new Item(itemName, itemWeight);
                    itemList.add(item);
                }
            }

            for (Item item: itemList) {
                System.out.println(item.getName());
            }
        return itemList;

        } catch ( Exception exception ) {
            return null;
        }
    }
}
