package org.example.design.patterns.decorator;

public class ChessBurst extends ToppingDecorator{
    BasePizza basePizza;
    ChessBurst (BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}
