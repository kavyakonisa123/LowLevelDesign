package com.parkinglot.design;

import java.util.*;

public class ParkingLotManager {
	public static void main(String[] args) throws InterruptedException {
		// spots on each floor
		List<ParkingSpot> smallSpots = List.of(new ParkingSpot("S1", SpotType.SMALL),
				new ParkingSpot("S2", SpotType.SMALL));

		List<ParkingSpot> mediumSpots = List.of(new ParkingSpot("M1", SpotType.MEDIUM),
				new ParkingSpot("M2", SpotType.MEDIUM), new ParkingSpot("M3", SpotType.MEDIUM));

		List<ParkingSpot> largeSpots = List.of(new ParkingSpot("L1", SpotType.LARGE));

		// Map spots to each of the three floors
		Map<SpotType, List<ParkingSpot>> floor1Spots = new HashMap<>();
		floor1Spots.put(SpotType.SMALL, smallSpots);
		floor1Spots.put(SpotType.MEDIUM, mediumSpots);
		floor1Spots.put(SpotType.LARGE, largeSpots);

        //    create floors based on above maps
		ParkingFloor floor1 = new ParkingFloor("F1", floor1Spots);

		List<ParkingFloor> floors = List.of(floor1);

		System.out.println("\nDisplay of parkingFloors -- initial:");
		floor1.getDisplayBoard().show();

		// strategy and payment service
		SpotAssignmentStrategy strategy = new Nearestspotstrategy();
		PaymentService paymentService = new PaymentService();

       //created gates
		EntryGate entryGate1 = new EntryGate("ENTRY1", strategy);
		ExitGate exitGate1 = new ExitGate("EXIT1", paymentService);

		List<EntryGate> entryGates = List.of(entryGate1);
		List<ExitGate> exitGates = List.of(exitGate1);

		ParkingLot parkingLot = new ParkingLot("LOT1", floors, entryGates, exitGates);

		// Inject parking lot reference into gates
		entryGate1 = new EntryGate("ENTRY1", strategy, parkingLot);

		System.out.println("\n--- VEHICLE ARRIVES ---");
		Vehicle vehicle = new Car("KA-01-9999");

		Ticket ticket = entryGate1.generateTicket(vehicle);
		System.out.println("Ticket Generated:");
		System.out.println("Ticket ID: " + ticket.getTickedId());
		System.out.println("Entry Time: " + ticket.getEntryTimestamp());
		System.out.println("Spot Assigned: " + ticket.getAssignedSpot().getSpotType());

		// Update display boards
		floor1.updateDisplayBoard();
		System.out.println("\nDisplay of parkingFloors after entry:");
		floor1.getDisplayBoard().show();

		Thread.sleep(3000);

		// At EXIT GATR
		System.out.println("\n--- VEHICLE EXITING ---");

		double amount = exitGate1.processExit(ticket);
		System.out.println("Payment Successful!");
		System.out.println("Total Fee = $" + amount);

		// Update display boards again
		floor1.updateDisplayBoard();
		System.out.println("\nDisplay of parkingFloors after exit:");
		floor1.getDisplayBoard().show();

		System.out.println("\n--- FLOW COMPLETE ---");

	}
}
