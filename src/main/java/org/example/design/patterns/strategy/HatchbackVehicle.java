package org.example.design.patterns.strategy;

public class HatchbackVehicle extends Vehicle{
    HatchbackVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
