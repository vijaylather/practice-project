package org.example.design.patterns.strategy;

public class RearWheelDrive implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Rear Wheel Drive");
    }
}
