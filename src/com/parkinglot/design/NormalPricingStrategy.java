package com.parkinglot.design;

import java.time.Duration;
import java.time.LocalDateTime;

public class NormalPricingStrategy implements PaymentStrategy{
	
	public double calculateFee(Ticket ticket) {
		long hours = Duration.between(ticket.getEntryTimestamp(), 
				 LocalDateTime.now()).toSeconds(); //it should be hours but for testing purpose, we changed to seconds
		System.out.println("total hours parked"+ hours);
		switch(ticket.getVehicle().getType())
		{
		case MOTORCYCLE: return hours*10;
		case CAR: return hours*20;
		case TRUCK: return hours*30;
        default: return hours * 20; 
		}
	}

}
