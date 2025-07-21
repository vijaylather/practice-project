package org.example.design.patterns.decorator;

import org.example.design.patterns.strategy.*;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza1 = new Thincrust(new PannerTikkaPizza());
        BasePizza pizza2 = new ChessBurst(new Thincrust(new MargritaPizza()));
        System.out.println(pizza1.cost());
        System.out.println(pizza2.cost());
    }
}
