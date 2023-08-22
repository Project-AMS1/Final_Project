package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Passenger;

public interface PassengerDao extends JpaRepository<Passenger, String> {

}
