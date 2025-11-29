package com.parkinglot.design;

public abstract class Vehicle {
	private String licenceNumber;
	private VehicleType type;

	public Vehicle(String licenceNumber, VehicleType type) {
		this.licenceNumber = licenceNumber;
		this.type = type;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}



}
