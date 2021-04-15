package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

	public static void outputTickets(List<Flight> flights) {
		for (Flight flight : flights) {
			System.out.println(flight);
		}
	}

	public static FlightFilter returnFilterObject() {
		return new FlightFilterImpl();
	}

	public static List<Flight> returnCopyCollectionTickets() {
		return new ArrayList<>(FlightBuilder.createFlights());
	}

}
