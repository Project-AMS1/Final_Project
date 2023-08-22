package com.org.model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="passenger")
@Getter
@Setter
@NoArgsConstructor
public class Passenger {

	@Id
	private int  aadhar;
	@Column(length=20)
	private String first_name;
	@Column(length=20)
	private int last_name;
	private int age;
	@Column(length=13)
	private String mobile_no;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private float lugguage_wt;
	private int seat_no;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private SeatClass seat_class;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="ticket_id")
	private TicketDetails ticketDetails;
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="meal_id")
	private Meal meal;

	

}
