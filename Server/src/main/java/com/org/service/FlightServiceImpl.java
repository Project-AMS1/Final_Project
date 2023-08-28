package com.org.service;

import com.org.exceptions.*;
import java.math.BigInteger;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dao.AeroplaneDao;
import com.org.dao.FlightDao;
import com.org.dto.AddFlightDto;
import com.org.dto.ShowFlighDto;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.model.Aeroplane;
import com.org.model.Flight;

@Transactional
@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;
	@Autowired
	AeroplaneDao aeroplaneDao;
	@Autowired
	ModelMapper mapper;

	/*
	 * add a flight
	 */
	@Override
	public Flight addFlight(AddFlightDto flight) {
//		Optional<Flight> findById = flightDao.findById(flight.getId());
		Aeroplane a= aeroplaneDao.findById(flight.getAeroplaneId()).orElseThrow();
		Flight f=mapper.map(flight, Flight.class);
		a.addFlight(f);
		return flightDao.save(f);
	}

	/*
	 * view all flights
	 */
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	/*
	 * search a flight
	 */
	@Override
	public Flight viewFlight(Long flightNumber) {
	
		Flight f = flightDao.findById(flightNumber).orElseThrow();
	
    return f;
	}
	/*
	 * modify a flight
	 */
	@Override
	public Flight modifyFlight(Flight flight) {
		Flight findById = flightDao.findById(flight.getId()).orElseThrow();
		
			return flightDao.save(flight);
	
	}

	/*
	 * remove a flight
	 */
	public String removeFlight(Long flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			flightDao.deleteById(flightNumber);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}

	@Override
	public Flight showFlight(ShowFlighDto flight) {
		
		return flightDao.findBySourceAndDestinationAndDate(flight.getSource(), flight.getDestination(),flight.getDate());
	}
}