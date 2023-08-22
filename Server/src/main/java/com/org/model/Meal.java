package com.org.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	int id;
	String dish_name;
	String dist_category;
	@ManyToMany(mappedBy = "mealList")
	private List<Flight> flightList=new ArrayList<>();
	

}
