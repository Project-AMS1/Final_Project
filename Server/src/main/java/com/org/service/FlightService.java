package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.dto.AddFlightDto;
import com.org.dto.ShowFlighDto;
import com.org.model.Flight;

public interface FlightService {
	public Flight addFlight(AddFlightDto flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(Long flightNumber);

	public Flight modifyFlight(Flight flight);

	public String removeFlight(Long flightNumber);

	public Flight showFlight(ShowFlighDto flight);

}