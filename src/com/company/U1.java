package com.company;

import java.util.Random;

public class U1 extends Rocket {
    public static int cost = 1000000000;

    public U1 () {
        super(10000, 18000 );
    }

    // We check chances of explosion out of a 1.000.000
    @Override
    public boolean launch () {
        double chancesToFail = 0.05;
        double chanceOfExplosion = chancesToFail * ((double)weight / (double)maxWeight) * 1000000;
        Random random = new Random();
        double randomNumber = random.nextInt(1000000 + 1);

        return chanceOfExplosion <= randomNumber;
    }

    // We check chances of explosion out of a 1.000.000
    @Override
    public boolean land () {
        double chancesToFail = 0.1;
        double chanceOfExplosion = chancesToFail * ((double)this.weight / (double)this.maxWeight) * 1000000;
        Random random = new Random();
        double randomNumber = random.nextInt(1000000 + 1);

        return chanceOfExplosion <= randomNumber;
    }
}
