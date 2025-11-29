package com.parkinglot.design;

public class PoliceCar extends Vehicle {
    public PoliceCar(String licenseNumber) {
        super(licenseNumber, VehicleType.POLICE_CAR);
    }
}