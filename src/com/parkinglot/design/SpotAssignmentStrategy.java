package com.parkinglot.design;

public interface SpotAssignmentStrategy {
	ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle);

}
