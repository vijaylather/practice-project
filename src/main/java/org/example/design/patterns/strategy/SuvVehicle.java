package org.example.design.patterns.strategy;

public class SuvVehicle extends Vehicle{
    SuvVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
