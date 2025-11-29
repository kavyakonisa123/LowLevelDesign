package com.parkinglot.design;

import java.util.*;

public class ParkingLot {
	String parkingLotId;
	List<ParkingFloor> parkingFloors = new ArrayList<>();
	List<EntryGate> entryGates = new ArrayList<>();
	List<ExitGate> exitGates = new ArrayList<>();
	
	public ParkingLot(String parkingLotId, List<ParkingFloor> parkingFloors, List<EntryGate> entryGates,
			List<ExitGate> exitGates) {
		this.parkingLotId = parkingLotId;
		this.parkingFloors = parkingFloors;
		this.entryGates = entryGates;
		this.exitGates = exitGates;
	}

	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}

	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public List<EntryGate> getEntryGates() {
		return entryGates;
	}

	public void setEntryGates(List<EntryGate> entryGates) {
		this.entryGates = entryGates;
	}

	public List<ExitGate> getExitGates() {
		return exitGates;
	}

	public void setExitGates(List<ExitGate> exitGates) {
		this.exitGates = exitGates;
	}
	
	
	


}
