package com.parkinglot.design;


public class EntryGate {
	private String id;
	private SpotAssignmentStrategy strategy;
	ParkingLot parkingLot;
	
	public EntryGate(String id, SpotAssignmentStrategy strategy) {
		this.id = id;
		this.strategy = strategy;
	}
	
	public EntryGate(String id, SpotAssignmentStrategy strategy,ParkingLot parkingLot) {
		this.id = id;
		this.strategy = strategy;
		this.parkingLot = parkingLot;
	}
	
	public Ticket generateTicket(Vehicle vehicle) {
		System.out.println("Vehicle " + vehicle.getLicenceNumber() + " in : " + parkingLot.parkingLotId);
		ParkingSpot spot= strategy.findSpot(parkingLot, vehicle);
		if(spot== null) throw new RuntimeException("No spot Available.. sorry");
		spot.parkVehicle(vehicle);
		return new Ticket("T-"+ System.currentTimeMillis(),spot,vehicle) ;
		
	}	
	
	
	

}
