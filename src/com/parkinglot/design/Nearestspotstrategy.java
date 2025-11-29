package com.parkinglot.design;

public class Nearestspotstrategy implements SpotAssignmentStrategy{

	public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
		for(ParkingFloor floor :lot.getParkingFloors() ) {
			System.out.println("Floor " + floor.getParkingFloorId() + " in : " + lot.getParkingLotId());

			ParkingSpot spot= floor.getAvailableSpot(getSpotType(vehicle));
			if(spot!=null) {
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
         default: return null;
     }
	}
	

}
