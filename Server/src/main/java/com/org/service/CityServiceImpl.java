package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.CityDao;
import com.org.model.City;

@Transactional
@Service
public class CityServiceImpl implements CityService{
	@Autowired
	private CityDao cityDao;  
	@Override
	public String addCity(City city) {
		cityDao.save(city);
		return "City has been added";
	}

	@Override
	public String removeCity(City city) {
		cityDao.delete(city);
		return "City has been deleted";
	}

}
