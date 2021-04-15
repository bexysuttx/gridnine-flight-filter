package com.gridnine.testing;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		System.out.println("----------------- initial data ----------");
		// logging the initial data
		Utils.outputTickets(FlightBuilder.createFlights());

		// Filter 1
		System.out.println("----------------- Filter 1 ----------");
		List<Flight> ticketsWithCorrectDepartureTime = Utils.returnFilterObject()
				.correctDateAndTimeDeparture(Utils.returnCopyCollectionTickets());
		Utils.outputTickets(ticketsWithCorrectDepartureTime);

		System.out.println("----------------- initial data ----------");
		// logging the initial data
		Utils.outputTickets(FlightBuilder.createFlights());

		// Filter 2
		System.out.println("----------------- Filter 2 ----------");
		List<Flight> ticketsWithCorrectArrivalTime = Utils.returnFilterObject()
				.correctDateAndTimeArrival(Utils.returnCopyCollectionTickets());
		Utils.outputTickets(ticketsWithCorrectArrivalTime);

		System.out.println("----------------- initial data ----------");
		// logging the initial data
		Utils.outputTickets(FlightBuilder.createFlights());

		// Filter 3
		System.out.println("----------------- Filter 3 ----------");
		List<Flight> ticketsWithlittleTimeOnEarth = Utils.returnFilterObject()
				.littleTimeOnEarth(Utils.returnCopyCollectionTickets());
		Utils.outputTickets(ticketsWithlittleTimeOnEarth);

	}
}
