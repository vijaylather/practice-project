package org.example.design.patterns.decorator;

public class Thincrust extends ToppingDecorator{
    BasePizza basePizza;
    Thincrust (BasePizza basePizza) {
        this.basePizza =  basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 30;
    }
}
