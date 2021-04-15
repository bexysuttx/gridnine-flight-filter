package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilter {

	/**
	 * Фильтр - вылет до текущего момента времени
	 * 
	 * @param flights - collection of tickets
	 * @return returns a collection of filtered tickets
	 */
	@Override
	public List<Flight> correctDateAndTimeDeparture(List<Flight> flights) {
		LocalDateTime currentDate = LocalDateTime.now();
		List<Segment> deleteFlight = flights.stream().map(flight -> flight.getSegments())
				.flatMap(segment -> segment.stream()).filter(s -> s.getDepartureDate().isBefore(currentDate))
				.collect(Collectors.toList());
		List<Flight> finalFlight = flights.stream().filter(s -> !s.getSegments().removeAll(deleteFlight))
				.collect(Collectors.toList());
		return finalFlight;
	}

	/**
	 * Фильтр - имеются сегменты с датой прилёта раньше даты вылета
	 * 
	 * @param flights - collection of tickets
	 * @return returns a collection of filtered tickets
	 */
	@Override
	public List<Flight> correctDateAndTimeArrival(List<Flight> flights) {

		List<Segment> deleteFlight = flights.stream().map(flight -> flight.getSegments())
				.flatMap(segment -> segment.stream()).filter(s -> s.getDepartureDate().isAfter(s.getArrivalDate()))
				.collect(Collectors.toList());
		List<Flight> finalFlight = flights.stream().filter(s -> !s.getSegments().removeAll(deleteFlight))
				.collect(Collectors.toList());
		return finalFlight;

	}

	/**
	 * Фильтр - общее время, проведённое на земле превышает два часа (время на земле
	 * — это интервал между прилётом одного сегмента и вылетом следующего за ним)
	 * Использовал алгоритм для разнообразия, хотя по скорости проигрывает стримам,
	 * но нужно показать же различные умения.
	 * 
	 * @param flights - collection of tickets
	 * @return returns a collection of filtered tickets
	 */
	@Override
	public List<Flight> littleTimeOnEarth(List<Flight> flights) {
		int iter = flights.size();
		for (int j = iter - 1; j >= 0; j--) {
			if (flights.get(j).getSegments().size() > 1) {
				int timeOnEarth = 0;
				for (int i = 0; i < flights.get(j).getSegments().size() - 1; i++) {
					LocalDateTime arrTime = flights.get(j).getSegments().get(i).getArrivalDate();
					LocalDateTime depTime = flights.get(j).getSegments().get(i + 1).getDepartureDate();
					timeOnEarth += arrTime.until(depTime, ChronoUnit.HOURS);
					if (timeOnEarth > 2) {
						flights.remove(j);
						break;
					}
				}
			}
		}
		return flights;
	}
}
