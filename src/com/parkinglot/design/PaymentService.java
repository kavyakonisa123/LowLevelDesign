package com.parkinglot.design;

import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentService {
	
	private PaymentStrategy normalPricing = new NormalPricingStrategy();
    private PaymentStrategy emergencyPricing = new EmergencyPricingStrategy();

	
	public double calculateFee(Ticket ticket) {
		
		if (EmergencyUtil.isEmergencyVehicle(ticket.getVehicle())) {
            return emergencyPricing.calculateFee(ticket);
        }

        return normalPricing.calculateFee(ticket);
		
	}
	
	
}
