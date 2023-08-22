package com.org.model;



import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="flight_table")
@Setter
@Getter
@NoArgsConstructor
public class Flight {
@Id
	private Long id ;
@Column(length=20)
	private String source; 
@Column(length=20)
	private String destination;
@DateTimeFormat(pattern = "yyyy-MM-dd")

	private LocalDate date_of_journey;
	private LocalTime arrival_time;
	private LocalTime departure_time;
	private double economyclass_price;
	private double premiumeconomyclass_price;
	private double businessclass_price;
	@Column(length=20)
	private String layoveer_location;
	private Duration layover_duration;
	@ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="plane_code")
	private AeroPlane aeroplane;
	
	@ManyToMany(cascade = CascadeType.PERSIST) // mandatory!
	@JoinTable(name="flight_meal",
	joinColumns = @JoinColumn(name="flight_id"),
	inverseJoinColumns = @JoinColumn(name="meal_id")
	)
	@JsonIgnore
	private List<Meal> mealList=new ArrayList<>();
	public void addMeal(Meal m) {
		mealList.add(m);// dept --> emp
		m.getFlightList().add(this);// emp --> dept
	}
	public void removeMeal(Meal m) {
		mealList.remove(m);
		m.getFlightList().remove(this);
	
	}
 
	@OneToMany
	(mappedBy = "flight",cascade = CascadeType.ALL, 
	orphanRemoval = true)
	@JsonIgnore
	private List<TicketDetails> ticketDetailsList=new ArrayList<>();
	public void addPassenger(TicketDetails t) {
		ticketDetailsList.add(t);// dept --> emp
		t.setFlight(this);// emp --> dept
	}
	public void removeTicketDetail(TicketDetails t) {
		ticketDetailsList.remove(t);
		t.setFlight(null);
	}
	

}
