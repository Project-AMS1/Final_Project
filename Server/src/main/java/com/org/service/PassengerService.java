package com.org.service;

import com.org.dto.AddPassengerDto;
import com.org.dto.RemovePassengerDto;
import com.org.model.City;
import com.org.model.Passenger;

public interface PassengerService {

	public String addPassenger(AddPassengerDto passenger);
	public String removePassenger(RemovePassengerDto passenger);
}
