package org.example.design.patterns.strategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle (DriveStrategy driveStrategy)
    {
        this.driveStrategy = driveStrategy;
    }

    public void drive()
    {
        this.driveStrategy.drive();
    }

}
