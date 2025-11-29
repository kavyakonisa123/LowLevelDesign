package com.parkinglot.design;


import java.time.LocalDateTime;

public class Ticket {
	private String tickedId;
	private ParkingSpot assignedSpot;
	private LocalDateTime entryTimestamp;
	private Vehicle vehicle;
	
	public Ticket(String tickedId, ParkingSpot assignedSpot, Vehicle vehicle) {
		this.tickedId = tickedId;
		this.assignedSpot = assignedSpot;
		this.entryTimestamp = LocalDateTime.now();
		this.vehicle = vehicle;
	}
	
	

	public String getTickedId() {
		return tickedId;
	}



	public void setTickedId(String tickedId) {
		this.tickedId = tickedId;
	}



	public ParkingSpot getAssignedSpot() {
		return assignedSpot;
	}

	public void setAssignedSpot(ParkingSpot assignedSpot) {
		this.assignedSpot = assignedSpot;
	}

	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
	}

	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
	
	
	

}
