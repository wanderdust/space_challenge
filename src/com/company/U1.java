package com.company;

import java.util.Random;

public class U1 extends Rocket {

    public U1 () {
        super(100000000, 10000, 18000 );
        System.out.println(this.land(this.weight, this.maxWeight, 0.01));
    }

}
