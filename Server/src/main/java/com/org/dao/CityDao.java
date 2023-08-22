package com.org.dao;

import org.springframework.data.repository.CrudRepository;

import com.org.model.Airport;
import com.org.model.City;

public interface CityDao extends CrudRepository<City, Long> {

}
