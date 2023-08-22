package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.PassengerDao;
import com.org.model.Passenger;

@Transactional
@Service
public class PassengerServiceimpl implements PassengerService{

	@Autowired
	PassengerDao passengerDao;
	@Override
	public String addPassenger(Passenger passenger) {
		passengerDao.save(passenger);
		return "passenger has been added";
	}

	@Override
	public String removePassenger(Passenger passenger) {
		passengerDao.delete(passenger);
		return "passenger has been removed";
	}

	
}
