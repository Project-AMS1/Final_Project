package com.org.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.PassengerDao;
import com.org.dao.TicketDetailsDao;
import com.org.dto.AddPassengerDto;
import com.org.dto.RemovePassengerDto;
import com.org.model.Passenger;
import com.org.model.TicketDetails;

@Transactional
@Service
public class PassengerServiceimpl implements PassengerService{

	@Autowired
	PassengerDao passengerDao;
	@Autowired
	TicketDetailsDao tdDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public String addPassenger(AddPassengerDto passenger) {
		TicketDetails td=tdDao.findById(passenger.getTicketDetailsId()).orElseThrow();
		Passenger p=mapper.map(passenger, Passenger.class);
		td.addPassenger(p);
		passengerDao.save(p);
		return "passenger has been added";
	}

	@Override
	public String removePassenger(RemovePassengerDto passenger) {
		TicketDetails td=tdDao.findById(passenger.getTicketDetailsId()).orElseThrow();
		Passenger p=mapper.map(passenger, Passenger.class);
		td.removePassenger(p);
		passengerDao.delete(p);
		return "passenger has been removed";
	}

	
}
