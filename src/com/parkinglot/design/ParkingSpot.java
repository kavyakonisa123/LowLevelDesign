package com.parkinglot.design;

public class ParkingSpot {

	private String spotid;
	private SpotType spotType;
	private boolean isOccupied;
	

	private Vehicle parkedVehicle;

	public ParkingSpot(String id, SpotType spotType) {
		this.spotid = id;
		this.spotType = spotType;
	}

	public void parkVehicle(Vehicle vehicle) {
		this.parkedVehicle = vehicle;
		this.isOccupied=true;

	}

	public void removeVehicle() {
		this.parkedVehicle = null;
		this.isOccupied=false;

	}

	public boolean isAvailable() {
		return !isOccupied();
	}

	public SpotType getSpotType() {
		return spotType;
	}

	public void setSpotType(SpotType spotType) {
		this.spotType = spotType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}

	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}



}
