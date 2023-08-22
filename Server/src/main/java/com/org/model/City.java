package com.org.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="city")
@NoArgsConstructor
public class City 
{
	
	@Id
	private Long pincode;
	
	private String city_name;
	@OneToMany(mappedBy = "city",cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnore
	private List <Airport> airportList=new ArrayList<>();
	
	public void addAirport(Airport a) 
	{
		airportList.add(a);
		a.setCity(this);
	}
	
	public void removeEmployee(Airport a) 
	{
		airportList.remove(a);
		a.setCity(null);
	}
	
}
