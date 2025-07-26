package org.example.design.patterns.factory;

public class Client {

    private ShapeFactory shapeFactory;

    Client(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public Shape getShapeObject() {
        return this.shapeFactory.createShape();
    }
}
