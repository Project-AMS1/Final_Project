package com.org.service;

import com.org.service.AirportService;
import java.math.BigInteger;
import java.util.Optional;

import com.org.model.Airport;
import com.org.model.City;
import com.org.model.Flight;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dao.AirportDao;
import com.org.dao.CityDao;
import com.org.dto.AddAirportDto;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;

@Transactional
@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportDao airportDao;
	@Autowired
	CityDao cityDao;
	@Autowired
	private ModelMapper mapper;

	/*
	 * view all Airports
	 */
	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportDao.findAll();
	}

	/*
	 * view airport by airportCode
	 */
	@Override
	public Airport viewAirport(String airportCode) {
		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<?> addAirport(AddAirportDto airport) {
			City c=cityDao.findById(airport.getCityId()).orElseThrow();
	Airport a=mapper.map(airport, Airport.class);
		c.addAirport(a);
			airportDao.save(a);
			return new ResponseEntity<Airport>(a,HttpStatus.OK);
		
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirport_name());
		if (findById.isPresent()) {
			airportDao.save(airport);
		} 
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirport_name() + " not exists");
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(String airportCode) {
		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			airportDao.deleteById(airportCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}
}
