package org.example.design.patterns.strategy;

public class FourWheelDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Four wheel Drive");
    }
}
