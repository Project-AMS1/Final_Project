package com.org.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.model.Gender;
import com.org.model.Meal;
import com.org.model.SeatClass;
import com.org.model.TicketDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class AddPassengerDto {

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
