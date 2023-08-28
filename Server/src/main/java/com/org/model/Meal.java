package com.org.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="meal")
@Getter
@Setter
@NoArgsConstructor
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dish_name;
	private String dist_category;
	@ManyToMany(mappedBy = "mealList")
	@JsonIgnore
	private List<Flight> flightList=new ArrayList<>();
	public void addFlight(Flight f) 
	{
		flightList.add(f);// dept --> emp
		f.getMealList().add(this);// emp --> dept
	}
	
	public void removeFlight(Flight f) 
	{
		flightList.remove(f);
f.getMealList().remove(this);
	}
	

}
