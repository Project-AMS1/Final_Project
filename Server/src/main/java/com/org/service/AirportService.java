package com.org.service;

import org.springframework.http.ResponseEntity;

import com.org.dto.AddAirportDto;
import com.org.model.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String airportCode);

	public ResponseEntity<?> addAirport(AddAirportDto airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(String airportCode);
}
