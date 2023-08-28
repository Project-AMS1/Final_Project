package com.org.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.model.Gender;
import com.org.model.SeatClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class RemovePassengerDto {
	private String  aadhar;
	
	
	private String first_name;
	
	
	private String last_name;
	
	private int age;
	

	private String mobile_no;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private float lugguage_wt;
	
	private int seat_no;
	
	@Enumerated(EnumType.STRING)
	private SeatClass seat_class;
	
	private Long ticketDetailsId;
	@JsonIgnore
	private Long mealId;

}

