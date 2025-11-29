package com.parkinglot.design;

import java.util.*;

public class ParkingLotManager {
	public static void main(String[] args) throws InterruptedException {
//		// spots on each floor
//		List<ParkingSpot> smallSpots = List.of(new ParkingSpot("S1", SpotType.SMALL),
//				new ParkingSpot("S2", SpotType.SMALL));
//
//		List<ParkingSpot> mediumSpots = List.of(new ParkingSpot("M1", SpotType.MEDIUM),
//				new ParkingSpot("M2", SpotType.MEDIUM), new ParkingSpot("M3", SpotType.MEDIUM));
//
//		List<ParkingSpot> largeSpots = List.of(new ParkingSpot("L1", SpotType.LARGE));
//
		// ------------ Create spots for each floor separately ------------
        Map<SpotType, List<ParkingSpot>> floor1Spots = createFloorSpots("F1");
        Map<SpotType, List<ParkingSpot>> floor2Spots = createFloorSpots("F2");
        Map<SpotType, List<ParkingSpot>> floor3Spots = createFloorSpots("F3");

        // ---- create floors based on above maps ------
		ParkingFloor floor1 = new ParkingFloor("F1", floor1Spots);
        ParkingFloor floor2 = new ParkingFloor("F2", floor2Spots);
        ParkingFloor floor3 = new ParkingFloor("F3", floor3Spots);

        List<ParkingFloor> floors = List.of(floor1, floor2, floor3);
        
        
        // ------------ Create Strategy & Payment ------------
        SpotAssignmentStrategy strategy = new Nearestspotstrategy();
        PaymentService paymentService = new PaymentService();

        // ------------ Create Gates ------------
        EntryGate entryGate1 = new EntryGate("ENTRY1", strategy);
        EntryGate entryGate2 = new EntryGate("ENTRY2", strategy);
        ExitGate exitGate1 = new ExitGate("EXIT1", paymentService);
        ExitGate exitGate2 = new ExitGate("EXIT2", paymentService);
        
        List<EntryGate> entryGates = List.of(entryGate1, entryGate2);
        List<ExitGate> exitGates = List.of(exitGate1, exitGate2);

        ParkingLot lot = new ParkingLot("LOT1", floors, entryGates, exitGates);

        // Inject parkingLot into entry gates
        entryGate1.setParkingLot(lot);
        entryGate2.setParkingLot(lot);
        
        // ------------one vehicle entry and exit-------------
//     // ------------ Show initial display ------------
//        System.out.println("=== INITIAL DISPLAY ===");
//        showAllFloors(lot);
//
//
//		System.out.println("\n--- VEHICLE ARRIVES ---");
//		Vehicle v1 = new Car("KA-01-9999");
//
//		Ticket t1 = entryGate1.generateTicket(v1);
//		System.out.println("Ticket Generated:");
//		System.out.println("Ticket ID: " + t1.getTickedId());
//		System.out.println("Entry Time: " + t1.getEntryTimestamp());
//		System.out.println("Spot Assigned: " + t1.getAssignedSpot().getSpotType());
//
//        showAllFloors(lot);
//
//
//		Thread.sleep(3000);
//
//		// At EXIT GATR
//		System.out.println("\n--- VEHICLE EXITING ---");
//
//		double amount = exitGate1.processExit(t1);
//		System.out.println("Payment Successful!");
//		System.out.println("Total Fee = $" + amount);
//
//        showAllFloors(lot);
//
//		System.out.println("\n--- FLOW COMPLETE ---");
        
        showAllFloors(lot);

        //------------SIMULATION--------------------
        List<Ticket> activeTickets = new ArrayList<>();
        Random random = new Random();
        int totalTicketsToGenerate = 15;
        int vehicleCounter = 1;
        
        System.out.println("\n=== STARTING ENTRY SIMULATION ===");
        for(int i=0;i< totalTicketsToGenerate;i++) {
        	Vehicle vehicle = randomVehicle(vehicleCounter++);
        	EntryGate gate= (random.nextBoolean()) ? entryGate1 : entryGate2;
        	
        	try {
        		Ticket ticket= gate.generateTicket(vehicle);
        		activeTickets.add(ticket);
        		System.out.println("Ticket Generated:");
        		System.out.println("Ticket ID: " + ticket.getTickedId());
        		System.out.println("Entry Time: " + ticket.getEntryTimestamp());
        		System.out.println("Spot Assigned: " + ticket.getAssignedSpot().getSpotType());	
        	}
        	catch (Exception e) {
                System.out.println("No spots available for vehicle " + vehicle.getLicenceNumber());
            }

            showAllFloors(lot);
            Thread.sleep(500); // small pause 
        }
        
        System.out.println("\n=== SIMULATING EXITS ===");
        
        double totalRevenue = 0;

        for (int i = 0; i < activeTickets.size(); i++) {
        	// only some vehicles exit
            if (i % 2 == 0) { 
                Ticket t = activeTickets.get(i);
                ExitGate gate = (random.nextBoolean()) ? exitGate1 : exitGate2;

                Thread.sleep(2000); // simulate parking time
                
                double fee = gate.processExit(t);
                totalRevenue += fee;

                System.out.println("\nVehicle " + t.getVehicle().getLicenceNumber() +
                        " exited. Total Fee = $" + fee);
                showAllFloors(lot);
        	
        }
        }
        
        System.out.println("\n=== SIMULATION COMPLETE ===");
        System.out.println("TOTAL REVENUE COLLECTED: $" + totalRevenue);

	}
	
	// Helper: create independent spot lists for each floor
    private static Map<SpotType, List<ParkingSpot>> createFloorSpots(String floorId) {
        Map<SpotType, List<ParkingSpot>> map = new HashMap<>();
        map.put(SpotType.SMALL, createSpots(floorId, SpotType.SMALL, 2));
        map.put(SpotType.MEDIUM, createSpots(floorId, SpotType.MEDIUM, 3));
        map.put(SpotType.LARGE, createSpots(floorId, SpotType.LARGE, 1));
        return map;
    }
	
	public static List<ParkingSpot> createSpots(String floorId, SpotType type, int count) {
	    List<ParkingSpot> spots = new ArrayList<>();
	    for (int i = 1; i <= count; i++) {
	        spots.add(new ParkingSpot(floorId + "-" + type + "-" + i, type));
	    }
	    return spots;
	}
	
	private static void showAllFloors(ParkingLot lot) {
        for (ParkingFloor f : lot.getParkingFloors()) {
            System.out.println("\nDisplay for Floor " + f.getParkingFloorId());
            f.updateDisplayBoard();
            f.getDisplayBoard().show();
        }
    }
	
	private static Vehicle randomVehicle(int count) {
        switch (count % 3) {
            case 0: return new Car("CAR-" + count);
            case 1: return new Motorcycle("BIKE-" + count);
            default: return new Truck("TRUCK-" + count);
        }
    }

}
