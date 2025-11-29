package com.parkinglot.design;

public class ExitGate {
	String exitGateId;
	private PaymentService paymentService;
	ParkingLot parkingLot;
	
	public ExitGate(String exitGateId, PaymentService paymentService) {
		this.exitGateId = exitGateId;
		this.paymentService = paymentService;
	}

	public double processExit(Ticket ticket) {
		double fee = paymentService.calculateFee(ticket);
		ticket.getAssignedSpot().removeVehicle();
		return fee;
		
		
	}
	
	
	

}
