package org.example.design.patterns.factory;

public class SquareShapeFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Square();
    }
}
