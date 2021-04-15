package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
	
	List<Flight> correctDateAndTimeDeparture(List<Flight> flights);
	
	List<Flight> correctDateAndTimeArrival(List<Flight> flights);
	
	List<Flight> littleTimeOnEarth(List<Flight> flights);
	

}
