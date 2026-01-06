package org.example.design.patterns.decorator;

public class ChessBurst extends ToppingDecorator{
    ChessBurst (BasePizza basePizza) {
        super(basePizza);
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 30;
    }
}
