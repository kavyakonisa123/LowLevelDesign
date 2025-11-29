package com.parkinglot.design;

import java.util.*;

public class ParkingFloor {
	private String parkingFloorId;
	private Map<SpotType, List<ParkingSpot>> SpotsByType;
	private DisplayBoard displayBoard;
	
	
	public ParkingFloor(String parkingFloorId, Map<SpotType, List<ParkingSpot>> spotsByType) {
		this.parkingFloorId = parkingFloorId;
		SpotsByType = spotsByType;
		this.displayBoard = new DisplayBoard(initialCounts());
		
	}
	
	public ParkingSpot getAvailableSpot(SpotType type) {
		for(ParkingSpot spot: SpotsByType.get(type)) {
			if(spot.isAvailable()) return spot;
		}
		return null;
		
	}

	private  Map<SpotType,Integer> initialCounts(){
		 Map<SpotType,Integer>  counts= new HashMap<>();
		 for( SpotType type : SpotsByType.keySet() ) {
			 counts.put(type,SpotsByType.get(type).size() );
			 
		 }
		return counts;
	}
	

	public String getParkingFloorId() {
		return parkingFloorId;
	}

	public void setParkingFloorId(String parkingFloorId) {
		this.parkingFloorId = parkingFloorId;
	}

	public Map<SpotType, List<ParkingSpot>> getSpotsByType() {
		return SpotsByType;
	}

	public void setSpotsByTpe(Map<SpotType, List<ParkingSpot>> spotsByType) {
		SpotsByType = spotsByType;
	}

	public DisplayBoard getDisplayBoard() {
		return displayBoard;
	}

	public void setDisplayBoard(DisplayBoard displayBoard) {
		this.displayBoard = displayBoard;
	}
	
	public void updateDisplayBoard() {
		for( SpotType type : SpotsByType.keySet() ) {
			int count = (int) SpotsByType.get(type)
					.stream()
					.filter(ParkingSpot::isAvailable)
					.count();
			displayBoard.updateAvailability(type,count);
		}
	}
	
	
	
	

}
