package com.org.dao;

import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Flight;
@Repository
public interface FlightDao extends JpaRepository<Flight,Long>{
 public  Flight findBySourceAndDestinationAndDate(String source,String destination,LocalDate date);
//	@Query("select f from flight_table f where f.source=:source and f.destination=:dest and Date(date_of_journey)=:date")
//	public Flight showFlight(String source,String dest,LocalDate date);

}