package com.parkinglot.design;

import java.util.Map;

public class DisplayBoard {
	private Map<SpotType, Integer> availableSpots;
	

	public DisplayBoard(Map<SpotType, Integer> availableSpots) {
		super();
		this.availableSpots = availableSpots;
	}


	public void updateAvailability(SpotType type, int count) {
		availableSpots.put(type, count);
		
	}
	
	public void show() {
		System.out.println("Available Spots: ");
		for(SpotType  type : availableSpots.keySet()) {
			System.out.println(type + ": "+availableSpots.get(type));
		}
	}

}
