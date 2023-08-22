package com.org.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="aeroplane")
@Getter
@Setter
@NoArgsConstructor
public class Aeroplane {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long plane_code;
  private int economy_seats;
  private int premiumecnomy_seats;
  private int business_seats;
  @OneToMany
  (mappedBy = "aeroplane",cascade = CascadeType.ALL, 
	orphanRemoval = true)
@JsonIgnore
  private List<Flight> flightList=new ArrayList<>();
  public void addFlight(Flight f) {
	  flightList.add(f);//
		f.setAeroplane(this);// 
	}
	public void removeFlight(Flight f) {
		flightList.remove(f);
		f.setAeroplane(null);
	}
}
