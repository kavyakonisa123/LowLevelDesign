package com.parkinglot.design;

public class EmergencyPrioritySpotStrategy implements SpotAssignmentStrategy {

    private final SpotAssignmentStrategy fallbackStrategy;

    public EmergencyPrioritySpotStrategy(SpotAssignmentStrategy fallbackStrategy) {
        this.fallbackStrategy = fallbackStrategy;
    }

    @Override
    public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {

        // Emergency vehicles get Floor 1 priority
        if (EmergencyUtil.isEmergencyVehicle(vehicle)) {

            ParkingFloor firstFloor = lot.getParkingFloors().get(0); // Floor F1
            SpotType requiredSpotType = getSpotType(vehicle);

            ParkingSpot spot = firstFloor.getAvailableSpot(requiredSpotType);

            if (spot != null) {
                System.out.println("Assigning priority spot on Floor 1 for emergency vehicle.");
                return spot;
            }
            // If unavailable → fallback to normal strategy
            System.out.println("Floor 1 full — falling back to nearest spot strategy.");
        }

        // Normal vehicles OR emergency fallback
        return fallbackStrategy.findSpot(lot, vehicle);
    }


    private SpotType getSpotType(Vehicle vehicle) {
        switch (vehicle.getType()) {
            case MOTORCYCLE: return SpotType.SMALL;
            case CAR, AMBULANCE ,POLICE_CAR: return SpotType.MEDIUM;
            case TRUCK, FIRE_TRUCK: return SpotType.LARGE;
        };
		return null;
    }
}