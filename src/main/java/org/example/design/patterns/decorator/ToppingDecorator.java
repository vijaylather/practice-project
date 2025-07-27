package org.example.design.patterns.decorator;

public abstract class ToppingDecorator extends BasePizza{
    private final BasePizza basePizza;

    ToppingDecorator (BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    public int cost() {
        return basePizza.cost();
    }
}
