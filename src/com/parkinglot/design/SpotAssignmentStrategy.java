package com.parkinglot.design;

public interface SpotAssignmentStrategy {
	ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle);
	/*
	 * We can create other strategies like:
	 * LowestFloorStrategy: always assigns the lowest available floor.
	 * 
	 * MostAvailableFloorStrategy: load balances traffic by choosing the floor with
	 * the max free spots.
	 * 
	 * RandomSpotStrategy: randomly selects a spot to simulate unpredictable
	 * distribution or testing behavior.
	 */
}
