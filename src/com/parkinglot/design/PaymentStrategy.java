package com.parkinglot.design;

public interface PaymentStrategy {
	double calculateFee(Ticket ticket);

}
