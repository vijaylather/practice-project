package org.example.design.patterns.decorator;

public class Thincrust extends ToppingDecorator{
    Thincrust (BasePizza basePizza) {
        super(basePizza);
    }
    @Override
    public int cost() {
        return super.cost() + 30;
    }
}
