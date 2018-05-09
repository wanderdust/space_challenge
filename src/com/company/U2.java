package com.company;

import java.util.Random;

public class U2 extends Rocket {

    public static int cost = 1200000000;

    public U2 () {
        super(18000, 29000 );
    }

    // We check chances of explosion out of a 1.000.000
    @Override
    public boolean launch () {
        double chancesToFail = 0.18;
        double chanceOfExplosion = chancesToFail * ((double)weight / (double)maxWeight) * 1000000;
        Random random = new Random();
        double randomNumber = random.nextInt(1000000 + 1);

        return chanceOfExplosion <= randomNumber;
    }

    // We check chances of explosion out of a 1.000.000
    @Override
    public boolean land () {
        double chancesToFail = 0.20;
        double chanceOfExplosion = chancesToFail * ((double)this.weight / (double)this.maxWeight) * 1000000;
        Random random = new Random();
        double randomNumber = random.nextInt(1000000 + 1);

        return chanceOfExplosion <= randomNumber;
    }

}
