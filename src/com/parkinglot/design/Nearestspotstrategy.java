package com.parkinglot.design;

import java.util.List;

public class Nearestspotstrategy implements SpotAssignmentStrategy{

	public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
		SpotType required = getSpotType(vehicle);

        // Loop floors from LAST to FIRST
        List<ParkingFloor> floors = lot.getParkingFloors();
        for (int i = floors.size() - 1; i >= 0; i--) {
            ParkingFloor floor = floors.get(i);
            ParkingSpot spot = floor.getAvailableSpot(required);

            if (spot != null) {
                System.out.println("Assigned spot from Floor: " + floor.getParkingFloorId());
                return spot;
            }
        }

        return null;
    }

	private SpotType getSpotType(Vehicle vehicle) {
		 switch (vehicle.getType()) {
         case MOTORCYCLE: return SpotType.SMALL;
         case CAR: return SpotType.MEDIUM;
         case TRUCK: return SpotType.LARGE;
         case AMBULANCE: return SpotType.MEDIUM;
         case FIRE_TRUCK: return SpotType.LARGE;
         case POLICE_CAR: return SpotType.MEDIUM;
         default: return null;
     }
	}
	

}
