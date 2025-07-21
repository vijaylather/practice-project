package org.example.design.patterns.strategy;

public class Main {
    public static void main(String[] args) {
        Vehicle suvVehicle = new SuvVehicle(new FourWheelDrive());
        Vehicle hacthbackVehicle = new HatchbackVehicle(new RearWheelDrive());
        suvVehicle.drive();
        hacthbackVehicle.drive();
    }
}
