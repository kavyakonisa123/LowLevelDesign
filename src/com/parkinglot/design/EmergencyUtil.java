package com.parkinglot.design;

public class EmergencyUtil {
    public static boolean isEmergencyVehicle(Vehicle vehicle) {
        return switch (vehicle.getType()) {
            case AMBULANCE, FIRE_TRUCK, POLICE_CAR -> true;
            default -> false;
        };
    }
}