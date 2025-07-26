package org.example.design.patterns.factory;

public class TriangleShapeFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}
