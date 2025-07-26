package org.example.design.patterns.factory;

public class Main {
    public static void main(String[] args) {

        Client squareShapeClient = new Client(new SquareShapeFactory());
        Client triangleShapeClient = new Client(new TriangleShapeFactory());
        Shape squareShape = squareShapeClient.getShapeObject();
        Shape triangleShape = triangleShapeClient.getShapeObject();
        squareShape.displayShape();
        triangleShape.displayShape();
    }
}
