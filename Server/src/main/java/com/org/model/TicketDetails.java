package com.org.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="ticket_details")
@Getter
@Setter
@NoArgsConstructor
public class TicketDetails {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int seats;
	
	private float discount;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private Users user;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="flight_Id")
	private Flight flight;
	
	@OneToMany(mappedBy = "ticketDetails",cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JsonIgnore
	private List<Passenger> PassengerList=new ArrayList<>();
	
	public void addPassenger(Passenger p) 
	{
		PassengerList.add(p);// dept --> emp
		p.setTicketDetails(this);// emp --> dept
	}
	
	public void removeTicketDetail(Passenger p) 
	{
		PassengerList.remove(p);
		p.setTicketDetails(null);
	}
	
}
