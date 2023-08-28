package com.org.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.model.Aeroplane;
import com.org.model.Meal;
import com.org.model.TicketDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor

public class AddFlightDto {

		private Long id ;
		
		private String source;
		private String destination;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate date_of_journey;

		@JsonFormat(pattern = "HH:mm:ss")
		private String deptDateTime;
		
		@JsonFormat(pattern = "HH:mm:ss")
		private String arrDateTime;
		
		private double economyclass_price;
		private double premiumeconomyclass_price;
		private double businessclass_price;
		
		private String layoveer_location;
		
		private int layover_duration;
		
		private Long aeroplaneId;
		

}
