package com.parkinglot.design;

public class EmergencyPricingStrategy implements PaymentStrategy{
	
	 @Override
	    public double calculateFee(Ticket ticket) {
	        System.out.println("Emergency vehicle fee waived: " + ticket.getVehicle().getType());
	        return 0.0;
	    }

}
